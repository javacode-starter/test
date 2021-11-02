package com.shujiu.test.dto;

import lombok.Getter;

/**
 * @author shujiu.cl
 * @since 2021/11/2
 */
public class Response {

    private Integer code;
    private String message;
    private Object data;


    public static Response success(Object data) {
        Response res = new Response();
        res.code = 0;
        res.data = data;
        return res;
    }
    public static Response success() {
        return success(null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
