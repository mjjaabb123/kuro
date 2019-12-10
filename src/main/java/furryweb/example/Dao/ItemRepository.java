package furryweb.example.Dao;

import furryweb.example.Model.ItemInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2019/12/11.
 */
public interface ItemRepository extends JpaRepository<ItemInfoEntity,Integer> {
    ItemInfoEntity findByItemId(int itemId);
}
