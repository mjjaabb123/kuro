package furryweb.example.Model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2019/10/24.
 */
public class RegisterForm {
    @NotEmpty(message = "账号不能为空")
    @Size(min = 6,max = 16,message = "字符长度在6-16之间")
    private String account;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6,max = 16,message = "字符长度在6-16之间")
    private String password;

    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    @NotEmpty(message = "昵称不能为空")
    @Size(min = 1,max = 12,message = "字符长度在1-12之间")
    private String name;

    @NotEmpty(message = "验证码不能为空")
    private String checkCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}