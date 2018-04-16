package cn.shana.slz.boot.response;

public class ResponseUtils {
    /**
     *自定义成功返回
     *
     * @param object 对象
     * @return appResponse
     */
    public static AppResponse success(Object object) {
        AppResponse<Object> response = new AppResponse<>();
        response.setCode(0);
        response.setData(object);
        response.setMessage("success");
        return response;
    }

    /**
     * 自定义成功返回
     *
     * @return appResponse
     */
    public static AppResponse success() {
        AppResponse<Object> response = new AppResponse<>();
        response.setCode(0);
        response.setData(null);
        response.setMessage("success");
        return response;
    }
    /**
     * 自定义错误返回
     *
     * @param errorEnum 错误枚举
     * @param msg  错误消息
     * @return appResponse
     */
    public static AppResponse error(ErrorEnum errorEnum, String msg) {
        AppResponse<Object> response = new AppResponse<>();
        response.setCode(errorEnum.getCode());
        response.setData(null);
        response.setMessage(msg);
        return response;
    }

    public static AppResponse error(ErrorEnum errorEnum) {
        AppResponse<Object> response = new AppResponse<>();
        response.setCode(errorEnum.getCode());
        response.setData(null);
        response.setMessage(errorEnum.getMsg());
        return response;
    }
}
