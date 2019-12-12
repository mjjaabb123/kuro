package furryweb.example.Model.Form;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Administrator on 2019/10/25.
 */
public class LoginForm {
    @NotEmpty(message = "账号不能为空")
    private String account;
    @NotEmpty(message = "密码不能为空")
    private String password;

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
}