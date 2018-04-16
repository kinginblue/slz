package cn.shana.slz.boot.handler;

import cn.shana.slz.boot.exception.BusinessException;
import cn.shana.slz.boot.response.AppResponse;
import cn.shana.slz.boot.response.ErrorEnum;
import cn.shana.slz.boot.response.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kinginblue on 2017/4/10.
 * @ControllerAdvice + @ExceptionHandler 实现全局的 Controller 层的异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${api.debug:false}")
    private boolean apiDebug = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    AppResponse<?> handleException(Exception e){
        LOGGER.error(e.getMessage(), e);

        return ResponseUtils.error(ErrorEnum.UNKNOW_ERROR);
    }

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    AppResponse<?> handleBusinessException(BusinessException e){
        LOGGER.error(e.getMessage(), e);

        return ResponseUtils.error(e.getErrorEnum(), e.getMessage());
    }

    /**
     * 处理所有接口验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    AppResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error(e.getMessage(), e);

        return ResponseUtils.error(ErrorEnum.PARAMS_ERROR, e.getMessage());
    }

}
