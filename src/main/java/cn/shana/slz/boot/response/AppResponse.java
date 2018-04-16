package cn.shana.slz.boot.response;

import lombok.Data;

@Data
public class AppResponse<T> {

    private int code = 200;
    private String message;
    private T data;

    public AppResponse() {
        super();
    }

    public AppResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
