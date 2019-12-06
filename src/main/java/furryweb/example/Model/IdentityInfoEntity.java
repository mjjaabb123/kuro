package furryweb.example.Model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2019/12/6.
 */
@Entity
@DynamicInsert
@Table(name = "identity_info", schema = "seekpigeon", catalog = "")
public class IdentityInfoEntity {
    private int userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String filesName;
    private String explicate;
    private String identityInfocol;
    private String identityInfocol1;
    private String identityInfocol2;
    private String identityInfocol3;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "files_name")
    public String getFilesName() {
        return filesName;
    }

    public void setFilesName(String filesName) {
        this.filesName = filesName;
    }

    @Basic
    @Column(name = "explicate")
    public String getExplicate() {
        return explicate;
    }

    public void setExplicate(String explicate) {
        this.explicate = explicate;
    }

    @Basic
    @Column(name = "identityInfocol")
    public String getIdentityInfocol() {
        return identityInfocol;
    }

    public void setIdentityInfocol(String identityInfocol) {
        this.identityInfocol = identityInfocol;
    }

    @Basic
    @Column(name = "identityInfocol1")
    public String getIdentityInfocol1() {
        return identityInfocol1;
    }

    public void setIdentityInfocol1(String identityInfocol1) {
        this.identityInfocol1 = identityInfocol1;
    }

    @Basic
    @Column(name = "identityInfocol2")
    public String getIdentityInfocol2() {
        return identityInfocol2;
    }

    public void setIdentityInfocol2(String identityInfocol2) {
        this.identityInfocol2 = identityInfocol2;
    }

    @Basic
    @Column(name = "identityInfocol3")
    public String getIdentityInfocol3() {
        return identityInfocol3;
    }

    public void setIdentityInfocol3(String identityInfocol3) {
        this.identityInfocol3 = identityInfocol3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdentityInfoEntity that = (IdentityInfoEntity) o;

        if (userId != that.userId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (filesName != null ? !filesName.equals(that.filesName) : that.filesName != null) return false;
        if (explicate != null ? !explicate.equals(that.explicate) : that.explicate != null) return false;
        if (identityInfocol != null ? !identityInfocol.equals(that.identityInfocol) : that.identityInfocol != null)
            return false;
        if (identityInfocol1 != null ? !identityInfocol1.equals(that.identityInfocol1) : that.identityInfocol1 != null)
            return false;
        if (identityInfocol2 != null ? !identityInfocol2.equals(that.identityInfocol2) : that.identityInfocol2 != null)
            return false;
        if (identityInfocol3 != null ? !identityInfocol3.equals(that.identityInfocol3) : that.identityInfocol3 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (filesName != null ? filesName.hashCode() : 0);
        result = 31 * result + (explicate != null ? explicate.hashCode() : 0);
        result = 31 * result + (identityInfocol != null ? identityInfocol.hashCode() : 0);
        result = 31 * result + (identityInfocol1 != null ? identityInfocol1.hashCode() : 0);
        result = 31 * result + (identityInfocol2 != null ? identityInfocol2.hashCode() : 0);
        result = 31 * result + (identityInfocol3 != null ? identityInfocol3.hashCode() : 0);
        return result;
    }
}