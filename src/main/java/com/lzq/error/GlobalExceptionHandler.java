package com.lzq.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//返回500状态码
    public RestErrorResponse processExcetion(HttpServletRequest request, HttpServletResponse response, Exception e){
        //异常处理
        //系统自定义异常取出errCode和errMessage
        if(e instanceof BusinessException){
            //控制台打印
            logger.info(e.getMessage(),e);
            //解析系统自定义异常
            BusinessException businessException = (BusinessException) e;
            ErrorCode errorCode = businessException.getErrorCode();
            //错误代码
            int code = errorCode.getCode();
            //错误信息
            String desc = errorCode.getMessage();
            return new RestErrorResponse(String.valueOf(code),desc);
        }
        //非自定义异常类型，定义为99999系统未知错误
        logger.error("系统异常:",e);
        return new RestErrorResponse(String.valueOf(CommonErrorCode.UNKNOWN.getCode()),CommonErrorCode.UNKNOWN.getMessage());
    }
}
