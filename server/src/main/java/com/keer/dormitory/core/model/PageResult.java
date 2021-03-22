package com.keer.dormitory.core.model;

public class PageResult<T> extends Result<PageData<T>> {

    public PageResult(){}

    public PageResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public PageResult(PageData<T> data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }

    public static <T>PageResult<T> ok(PageData<T> data) {
        return new PageResult<>(data);
    }

    public static PageResult error(String msg) {
        return new PageResult(ERROR_CODE, msg);
    }
}
