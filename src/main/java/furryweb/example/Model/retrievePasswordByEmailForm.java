package furryweb.example.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2019/12/1.
 */
public class retrievePasswordByEmailForm {
    @Size(min = 6,max = 16,message = "输入字符长度在6-16之间")
    @NotEmpty(message = "账号不能为空")
    private String account;


    @NotEmpty(message = "验证码不能为空")
    private String checkCode;


    @Size(min = 6,max = 16,message = "输入字符长度在6-16之间")
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}