package com.abucloud.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/9 23:28
 */
@Component
@RestControllerAdvice
public class GlobalHandlerExceptionResolver {

    @ExceptionHandler(CustomException.class)
    public String handlerCustomException(CustomException ex) {
        return ex.getMessage();
    }
}
