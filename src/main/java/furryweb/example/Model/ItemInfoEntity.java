package furryweb.example.Model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2019/12/10.
 */
@Entity
@DynamicInsert
@Table(name = "item_info", schema = "seekpigeon", catalog = "")
public class ItemInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @NotEmpty(message = "项目名不能为空")
    @Size(min = 3,max = 20,message = "项目名长度在3-20之间")
    private String itemName;
    @Size(max = 250,message = "项目描述不超过250字")
    private String itemDescribe;
    private Integer itemTime;
    @NotEmpty(message = "发布者id不能为空")
    private int publisherId;
    private int price;
    private Integer applyNum;
    private String tag;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String itemInfocol1;
    private String itemInfocol2;

    @Id
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "item_name")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_describe")
    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }

    @Basic
    @Column(name = "item_time")
    public Integer getItemTime() {
        return itemTime;
    }

    public void setItemTime(Integer itemTime) {
        this.itemTime = itemTime;
    }

    @Basic
    @Column(name = "publisher_id")
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "apply_num")
    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
    @Column(name = "item_infocol1")
    public String getItemInfocol1() {
        return itemInfocol1;
    }

    public void setItemInfocol1(String itemInfocol1) {
        this.itemInfocol1 = itemInfocol1;
    }

    @Basic
    @Column(name = "item_infocol2")
    public String getItemInfocol2() {
        return itemInfocol2;
    }

    public void setItemInfocol2(String itemInfocol2) {
        this.itemInfocol2 = itemInfocol2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemInfoEntity that = (ItemInfoEntity) o;

        if (itemId != that.itemId) return false;
        if (publisherId != that.publisherId) return false;
        if (price != that.price) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (itemDescribe != null ? !itemDescribe.equals(that.itemDescribe) : that.itemDescribe != null) return false;
        if (itemTime != null ? !itemTime.equals(that.itemTime) : that.itemTime != null) return false;
        if (applyNum != null ? !applyNum.equals(that.applyNum) : that.applyNum != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (itemInfocol1 != null ? !itemInfocol1.equals(that.itemInfocol1) : that.itemInfocol1 != null) return false;
        if (itemInfocol2 != null ? !itemInfocol2.equals(that.itemInfocol2) : that.itemInfocol2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemDescribe != null ? itemDescribe.hashCode() : 0);
        result = 31 * result + (itemTime != null ? itemTime.hashCode() : 0);
        result = 31 * result + publisherId;
        result = 31 * result + price;
        result = 31 * result + (applyNum != null ? applyNum.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (itemInfocol1 != null ? itemInfocol1.hashCode() : 0);
        result = 31 * result + (itemInfocol2 != null ? itemInfocol2.hashCode() : 0);
        return result;
    }
}