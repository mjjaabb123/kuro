package furryweb.example.Dao;

import furryweb.example.Model.IdentityInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/12/6.
 */
@Repository
public interface IdentityInfoRepository extends JpaRepository<IdentityInfoEntity,Integer> {
    IdentityInfoEntity findByUserId(int userId);
}
