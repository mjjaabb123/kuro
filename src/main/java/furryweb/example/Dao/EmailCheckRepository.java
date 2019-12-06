package furryweb.example.Dao;

import furryweb.example.Model.EmailCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/10/24.
 */
@Repository
public interface EmailCheckRepository extends JpaRepository<EmailCheckEntity,String> {
    EmailCheckEntity findByUserEmail(String user_email);
}
