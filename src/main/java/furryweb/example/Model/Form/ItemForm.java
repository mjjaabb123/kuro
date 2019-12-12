package furryweb.example.Model.Form;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
public class ItemForm {
    private int price;
    private String itemName;
    private String itemDescribe;
    private int itemTime;
    private int applyNum;
    private String tag;
    private String pictureName;

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }

    public int getItemTime() {
        return itemTime;
    }

    public void setItemTime(int itemTime) {
        this.itemTime = itemTime;
    }

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}