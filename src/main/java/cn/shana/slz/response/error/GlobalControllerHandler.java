package cn.shana.slz.response.error;


import cn.shana.slz.response.AppResponse;
import cn.shana.slz.response.SerializedField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局Controller拦截器
 * 处理异常、过滤字段以及加密（开发ing）字段
 */
@ControllerAdvice
public class GlobalControllerHandler implements ResponseBodyAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerHandler.class);

    /**
     * 返回项
     */
    private String[] includes = {};
    /**
     * 过滤项
     */
    private String[] excludes = {};
    /**
     * 是否加密
     */
    private boolean encode = false;

    /**
     * 处理controller层异常
     * @param e 异常
     * @return AppResponse
     */
    @ExceptionHandler()
    @ResponseBody
    AppResponse<?> handleException(Exception e) {
        LOGGER.error(e.getMessage(),e);
        return ResponseUtils.error(ErrorEnum.UNKNOW_ERROR);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //重置为默认值
        includes=new String[]{};
        excludes=new String[]{};
        encode=false;
        //对body类型进行区分
        if(returnType.getMethod().isAnnotationPresent(SerializedField.class)){
            SerializedField serializedField = returnType.getMethodAnnotation(SerializedField.class);
            includes = serializedField.includes();
            excludes = serializedField.excludes();
            encode = serializedField.encode();
        }
        return handleObject(body);
    }

    /**
     * 处理返回值是单个对象
     *
     * @param object 对象
     * @return 对象
     */
    private Object handleObject(Object object){
        if(object==null){
            return null;
        }
        HashMap<String, Object> objectHashMap = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field:fields)
            if (field.getName().equals("data")) {
                try {
                    field.setAccessible(true);
                    Object data = field.get(object);
                    if(data==null){
                        objectHashMap.put("data",null);
                    }else{
                        if (data instanceof List) {
                        ArrayList<Object> mapList = new ArrayList<>();
                        for (Object ignored : (List)data) {
                            Map<String, Object> map =  getDataMap(field,data);
                            mapList.add(map);
                        }
                        objectHashMap.put("data", mapList);
                        } else {
                            // 从对象取出data对象解析
                            objectHashMap.put("data", getDataMap(field, data));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                //重新将data对象放置回去
            } else {
                objectHashMap.put(field.getName(), getValue(object, field));
            }
        return objectHashMap;
    }

    /**
     * 解析data对象
     *
     * @param field 域
     * @param object 对象
     * @return map集合
     */
    private Map<String,Object> getDataMap(Field field,Object object){
        HashMap<String, Object> dataMap = new HashMap<>();
        try {
            field.setAccessible(true);
            Object data = field.get(object);
            Field[] dataFields = data.getClass().getDeclaredFields();
            for(Field dataField:dataFields){
                //如果未配置表示全部的都返回
                if(includes.length==0 && excludes.length==0){
                    dataMap.put(dataField.getName(), getValue(data, dataField));
                }else if(includes.length>0){
                    //有限考虑包含字段
                    if(isStringInArray(field.getName(), includes)){
                        dataMap.put(dataField.getName(), getValue(data, dataField));
                    }
                }else{
                    //去除字段
                    if(excludes.length>0){
                        if(!isStringInArray(field.getName(), excludes)){
                            dataMap.put(field.getName(), getValue(data, field));
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dataMap;
    }
    private String getValue(Object o, Field field){
        String value="";
        try {
            field.setAccessible(true);
            value= String.valueOf(field.get(o)) ;
//            这个地方可以做加密扩展
//            if(val!=null){
//                if(encode){
//                    value = Helper.encode(val.toString());
//                }else{
//                    value = val.toString();
//                }
//            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 检测该string是否在数组之中
     * @param str string
     * @param array string数组
     * @return true or false
     */
    private static boolean isStringInArray(String str, String[] array){
        for (String val:array){
            if(str.equals(val)){
                return true;
            }
        }
        return false;
    }
}
