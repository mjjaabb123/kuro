package furryweb.example.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by Administrator on 2019/10/21.
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 用于错误处理
     * @param code 错误码
     * @param message 错误提示信息
     */
    public Result(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public static  Result<String> error(Integer code,String msg){
        return new Result<>(code,msg);
    }

}