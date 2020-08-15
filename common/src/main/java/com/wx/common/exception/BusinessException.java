package com.wx.common.exception;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;
    private int errorcode = 500;

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public BusinessException(int errorcode, String message) {
        super(message);
        this.errorcode = errorcode;
        this.message = message;
    }

    public BusinessException(int errorcode, String message, Throwable e) {
        super(message,e);
        this.errorcode = errorcode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }
}
