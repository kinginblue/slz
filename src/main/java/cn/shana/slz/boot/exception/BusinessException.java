package cn.shana.slz.boot.exception;

import cn.shana.slz.boot.response.ErrorEnum;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

    private ErrorEnum errorEnum;

    private String message;

    public BusinessException(ErrorEnum errorEnum, String message) {
        this.errorEnum = errorEnum;
        this.message = message;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
