package cn.shana.slz.boot.response;

/**
 * 自定义枚举类
 */
public enum ErrorEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    PARAMS_ERROR(-2, "参数错误"),
    USER_NOT_FIND(-101, "用户不存在"),
    USER_IS_EXITED(-1, "用户已经存在请登录");

    private Integer code;

    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}