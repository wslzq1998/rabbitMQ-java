package com.lzq.error;

public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 5565760508056698922L;

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode){
        super();
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
