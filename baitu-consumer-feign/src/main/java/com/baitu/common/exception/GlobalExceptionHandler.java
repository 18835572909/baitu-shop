package com.baitu.common.exception;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.baitu.common.APIResponse;


/**
 * @author renhuibo  2019-11-06 21:53:14
 * @Description 全局异常处理
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    
    @ExceptionHandler(Exception.class)
    public BaituError handleException(Exception e){
        e.printStackTrace();
        return BaituError.SERVER_ERROR;
    }

    @ExceptionHandler(BaituException.class)
    public BaituError handleBusinessException(BaituException e){
        e.printStackTrace();
        return BaituError.BAITU_ERROE;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaituError handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        e.printStackTrace();
        return BaituError.REQUEST_PARAM_ERROR;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        e.printStackTrace();
        return APIResponse.instance(20002,errorMessage(e.getBindingResult()));
    }

    @ExceptionHandler(BindException.class)
    public APIResponse handleBindException(BindException e){
        e.printStackTrace();
        return APIResponse.instance(20002,errorMessage(e.getBindingResult()));
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaituError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return BaituError.REQUEST_PARSING_ERROR;
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public APIResponse handleServiceException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return APIResponse.instance(20002, message);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public BaituError noHandlerFoundException(NoHandlerFoundException e) {
        return BaituError.REQUEST_404_ERROR;
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaituError handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return BaituError.REQUEST_METHOD_ERROE;
    }
    
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public BaituError handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return BaituError.REQUEST_RESOURCE_ERROR;
    }
    
    public static String errorMessage(BindingResult bindingResult) {
        String errorMessage = "";
        if (bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError error : list) {
                errorMessage += "," + error.getField() + " : "+ error.getDefaultMessage();
            }
        }
        return errorMessage.replaceFirst(",","");
    }
}
