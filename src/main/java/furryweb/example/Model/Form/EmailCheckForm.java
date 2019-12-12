package furryweb.example.Model.Form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Administrator on 2019/11/6.
 */
public class EmailCheckForm {
    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}