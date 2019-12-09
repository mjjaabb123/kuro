package furryweb.example.Controller;

import furryweb.example.Model.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by Administrator on 2019/10/21.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e, HttpServletResponse response){
        //将错误信息返回给前台
        response.setStatus(400);
        return Result.error(405, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }
}