package furryweb.example.Service;

import furryweb.example.Dao.IdentityInfoRepository;
import furryweb.example.Dao.UserRepository;
import furryweb.example.Model.IdentityForm;
import furryweb.example.Model.IdentityInfoEntity;
import furryweb.example.Model.UserInfoEntity;
import furryweb.example.Model.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2019/9/29.
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IdentityInfoRepository identityInfoRepository;

    public int CheckLogin(String user_account, String user_password) {
        UserInfoEntity b = userRepository.findByUserAccountAndUserPassword(user_account, user_password);
        if (b == null) {
            return -1;
        }
        String aString = b.getUserAccount();
        String bString = b.getUserPassword();
        System.out.println("++++++++++++++++++++++++++++++" + aString + " and " + bString);
        return b.getUserId();
    }

    public boolean findUserByAccount(String userAccount) {
        if (userRepository.findByUserAccount(userAccount) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean CheckRegisterByEmail(String userEmail) {
        UserInfoEntity users = userRepository.findByUserEmail(userEmail);
        if (users == null) {
            return true;
        }
        return false;
    }

    public void Register(UserInfoEntity user) {
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
    }

    public void alterInfo(int userId, UserInfoForm userInfo) {
        UserInfoEntity user = userRepository.findByUserId(userId);
        user.setUserQq(userInfo.getQq());
        user.setUserProfile(userInfo.getProfile());
        user.setUserName(userInfo.getName());
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        if (userInfo.getIcon() != null) {
            user.setUserIcon(userInfo.getIcon());
        }
        user.setUserQQShow(userInfo.isQqShow());
        userRepository.save(user);
    }

    public Map<String, Object> getUserCentreInfo(int userId) {
        UserInfoEntity userInfoEntity = userRepository.findByUserId(userId);
        Map<String, Object> userInfo = new HashMap<>();
        try {
            userInfo.put("name", userInfoEntity.getUserName());
            userInfo.put("qq", userInfoEntity.getUserQq());
            userInfo.put("profile", userInfoEntity.getUserProfile());
            userInfo.put("qqShow", userInfoEntity.getUserQQShow());
            userInfo.put("email", userInfoEntity.getUserEmail());
            userInfo.put("icon", userInfoEntity.getUserIcon());
            userInfo.put("identity", userInfoEntity.getUserIdentity());
            userInfo.put("account",userInfoEntity.getUserAccount());
            return userInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getPasswordByUserId(int userId) {
        return userRepository.findByUserId(userId).getUserPassword();
    }

    public void alterPassword(int userId, String password) {
        UserInfoEntity userInfoEntity = userRepository.findByUserId(userId);
        userInfoEntity.setUserPassword(password);
        userRepository.save(userInfoEntity);
    }

    public void retrievePassword(String account, String password) {
        UserInfoEntity userInfoEntity = userRepository.findByUserAccount(account);
        userInfoEntity.setUserPassword(password);
        userRepository.save(userInfoEntity);
    }

    public String getEmailByUserAccount(String account) {
        return userRepository.findByUserAccount(account).getUserEmail();
    }

    public void uploadIdentityInfo(IdentityForm identityForm, int userId) {
        IdentityInfoEntity identityInfoEntity = new IdentityInfoEntity();
        identityInfoEntity.setUserId(userId);
        identityInfoEntity.setExplicate(identityForm.getExplicate());
        identityInfoEntity.setFilesName(identityForm.getPicturesName());
        identityInfoRepository.save(identityInfoEntity);
    }

    public void setIdentity(int identity, int userId) {
        UserInfoEntity userInfoEntity = userRepository.findByUserId(userId);
        userInfoEntity.setUserIdentity(identity);
        userRepository.save(userInfoEntity);
    }

    public UserInfoEntity getUserById(int userId) {
        return userRepository.findByUserId(userId);
    }

    public boolean getUserVerifyInfo(int userId) {
        return userRepository.findByUserId(userId).isUserIdentityVerify();
    }

    public int getUserIdentity(int userId) {
        return userRepository.findByUserId(userId).getUserIdentity();
    }
}