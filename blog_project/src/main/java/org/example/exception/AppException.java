package org.example.exception;

/**
 * 自定义异常类：业务代码抛自定义异常或其他异常
 * 自定义异常返回给定的错误码，其他异常返回其他的错误码
 * @author nuonuo
 * @create 2020-12-01 16:08
 */
public class AppException extends RuntimeException{
    private String code;//抛出异常的错误码
    public AppException(String code, String message) {
//        super(messa ge);
//        this.code = code;
        this(code,message,null);
    }

    public AppException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
