package furryweb.example.Model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2019/10/25.
 */
@Entity
@DynamicInsert
@Table(name = "email_check", schema = "seekpigeon", catalog = "")
public class EmailCheckEntity {
    public EmailCheckEntity(@Email(message = "邮箱格式不正确") @NotEmpty(message = "邮箱不能为空") String userEmail, String userCode, Timestamp createTime, Timestamp updateTime, Timestamp expireTime) {
        this.userEmail = userEmail;
        this.userCode = userCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expireTime = expireTime;
    }

    public EmailCheckEntity(@Email(message = "邮箱格式不正确") @NotEmpty(message = "邮箱不能为空") String userEmail, String userCode, Timestamp updateTime, Timestamp expireTime) {
        this.userEmail = userEmail;
        this.userCode = userCode;
        this.updateTime = updateTime;
        this.expireTime = expireTime;
    }

    public EmailCheckEntity(){

    }
    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String userEmail;
    private String userCode;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp expireTime;

    @Id
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_code")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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
    @Column(name = "expire_time")
    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailCheckEntity that = (EmailCheckEntity) o;

        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (expireTime != null ? !expireTime.equals(that.expireTime) : that.expireTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userEmail != null ? userEmail.hashCode() : 0;
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (expireTime != null ? expireTime.hashCode() : 0);
        return result;
    }
}