package furryweb.example.Model.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2019/12/1.
 */
public class AlterPasswordForm {
    private String oldPassword;

    @Size(min = 6,max = 16,message = "输入字符长度在6-16之间")
    @NotEmpty(message = "密码不能为空")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}