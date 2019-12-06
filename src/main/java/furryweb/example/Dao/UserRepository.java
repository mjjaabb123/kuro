package furryweb.example.Dao;

import furryweb.example.Model.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Administrator on 2019/9/29.
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfoEntity,Integer> {
    UserInfoEntity findByUserAccountAndUserPassword(String user_account, String user_password);
    UserInfoEntity findByUserAccount(String user_account);
    UserInfoEntity findByUserEmail(String user_email);
    UserInfoEntity findByUserId(int user_id);
}
