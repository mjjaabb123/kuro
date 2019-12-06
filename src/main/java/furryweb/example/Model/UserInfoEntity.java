package furryweb.example.Model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2019/10/24.
 */
@Entity
@DynamicInsert
@Table(name = "user_info", schema = "seekpigeon")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Size(min = 6,max = 16,message = "输入字符长度在6-16之间")
    @NotEmpty(message = "账号不能为空")
    private String userAccount;

    @Size(min = 6,max = 16,message = "输入字符长度在6-16之间")
    @NotEmpty(message = "密码不能为空")
    private String userPassword;

    private Timestamp createTime;
    private Timestamp updateTime;

    @NotEmpty(message = "昵称不能为空")
    private String userName;

    private boolean userQQShow;
    private String userProfile;
    private String userQq;

    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String userEmail;

    private int userIdentity;


    private boolean userIdentityVerify;

    @Basic
    @Column(name = "user_identity_verify")
    public boolean isUserIdentityVerify() {
        return userIdentityVerify;
    }

    public void setUserIdentityVerify(boolean userIdentityVerify) {
        this.userIdentityVerify = userIdentityVerify;
    }

    private String userIcon;
    private String userInfocol1;

    public UserInfoEntity(){

    }
    public UserInfoEntity(@NotEmpty(message = "账号不能为空") String userAccount, @NotEmpty(message = "密码不能为空") String userPassword, @NotEmpty(message = "昵称不能为空") String userName, @Email(message = "邮箱格式不正确") @NotEmpty(message = "邮箱不能为空") String userEmail) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_qqshow")
    public boolean getUserQQShow() {
        return userQQShow;
    }

    public void setUserQQShow(boolean userQQShow) {
        this.userQQShow = userQQShow;
    }

    @Basic
    @Column(name = "user_profile")
    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    @Basic
    @Column(name = "user_qq")
    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    @Basic
    @Column(name = "user_identity")
    public int getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(int userIdentity) {
        this.userIdentity = userIdentity;
    }


    @Basic
    @Column(name = "user_account")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_icon")
    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Basic
    @Column(name = "user_infocol1")
    public String getUserInfocol1() {
        return userInfocol1;
    }

    public void setUserInfocol1(String userInfocol1) {
        this.userInfocol1 = userInfocol1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (userId != that.userId) return false;
        if (userQQShow != that.userQQShow) return false;
        if (userIdentity != that.userIdentity) return false;
        if (userIdentityVerify != that.userIdentityVerify) return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userProfile != null ? !userProfile.equals(that.userProfile) : that.userProfile != null) return false;
        if (userQq != null ? !userQq.equals(that.userQq) : that.userQq != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userIcon != null ? !userIcon.equals(that.userIcon) : that.userIcon != null) return false;
        return userInfocol1 != null ? userInfocol1.equals(that.userInfocol1) : that.userInfocol1 == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userQQShow ? 1 : 0);
        result = 31 * result + (userProfile != null ? userProfile.hashCode() : 0);
        result = 31 * result + (userQq != null ? userQq.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + userIdentity;
        result = 31 * result + (userIdentityVerify ? 1 : 0);
        result = 31 * result + (userIcon != null ? userIcon.hashCode() : 0);
        result = 31 * result + (userInfocol1 != null ? userInfocol1.hashCode() : 0);
        return result;
    }
}