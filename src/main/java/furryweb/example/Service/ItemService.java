package furryweb.example.Service;

import furryweb.example.Dao.ItemRepository;
import furryweb.example.Model.ItemForm;
import furryweb.example.Model.ItemInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2019/12/11.
 */
@Service("ItemService")
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public void commitItem(ItemForm itemForm,int userId) {
        ItemInfoEntity itemInfoEntity = new ItemInfoEntity();
        itemInfoEntity.setItemName(itemForm.getItemName());
        itemInfoEntity.setItemDescribe(itemForm.getItemDescribe());
        itemInfoEntity.setApplyNum(itemForm.getApplyNum());
        itemInfoEntity.setPrice(itemForm.getPrice());
        itemInfoEntity.setItemTime(itemForm.getItemTime());
        itemInfoEntity.setPublisherId(userId);
        itemInfoEntity.setTag(itemForm.getTag());
        itemInfoEntity.setItemPictureName(itemForm.getPictureName());
        itemInfoEntity.setItemVerify(false);
        itemInfoEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        itemInfoEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        itemRepository.save(itemInfoEntity);
    }
}