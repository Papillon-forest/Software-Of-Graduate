package com.ks.glxt.exception;

import com.ks.glxt.util.ok;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
//(basePackages = "com.ks.glxt.publics.controller")
//annotations = RestController.class
public class jsrErrorController {
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ok<Map<String,String>> handleVaildException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        ok<Map<String,String>> success = new ok<>();
        Map<String , String> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach((item) -> {
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put(field, message);
                success.setObject(map);
                success.setStart("400");
                success.setMessage("参数异常");
            });
        }
        return success;
    }

    @ExceptionHandler(value = Throwable.class)
    public ok<String> handleException(Throwable throwable){
        ok<String> success = new  ok<>();
        success.setMessage("error"+throwable.getMessage());
        success.setStart("400");
        return success;
    }

//    @ExceptionHandler(value = ConstraintViolationException.class)
//    public ok<Map<String,String>> handleVaildExceptions(MethodArgumentNotValidException e){
//        return null;
//    }
}