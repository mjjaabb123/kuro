package furryweb.example.Model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Administrator on 2019/11/8.
 */
public class UserInfoForm {
    @NotEmpty(message = "昵称不能为空")
    private String name;
    private String qq;
    private boolean qqShow;


    public boolean isQqShow() {
        return qqShow;
    }

    public void setQqShow(boolean qqShow) {
        this.qqShow = qqShow;
    }

    private String profile;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

}