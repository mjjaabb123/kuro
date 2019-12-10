package furryweb.example.Controller;

import furryweb.example.Model.*;
import furryweb.example.Service.ItemService;
import furryweb.example.Service.UserService;
import furryweb.example.Util.FileUtil;
import furryweb.example.Util.JwtUtil;
import furryweb.example.Util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/11/7.
 */
@RequestMapping(value = "/api")
@RestController
public class UserCentreController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Value("${web.upload-path}")
    private String webUploadPath;

    private static final Logger logger = LoggerFactory.getLogger(UserCentreController.class);


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public Result alterInfo(@Valid @RequestBody UserInfoForm userInfoForm, @PathVariable("userId") int userId) {
        try {
            userService.alterInfo(userId, userInfoForm);
            return new Result(200, "资料保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(611, "资料保存失败");
        }
    }


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Result userCentre(@PathVariable("userId") int userId) {
        try {
            Map<String, Object> userCentreInfo = userService.getUserCentreInfo(userId);
            if (userCentreInfo != null) {
                return new Result(200, "返回用户信息", userCentreInfo);
            } else {
                return Result.error(551, "返回用户信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(551, "返回用户信息失败");
        }
    }

    @RequestMapping(value = "/password/{userId}", method = RequestMethod.PUT)
    public Result userAlterPassword(@RequestBody AlterPasswordForm alterPasswordForm, @PathVariable("userId") int userId) {
        try {
            if (!alterPasswordForm.getOldPassword().equals(userService.getPasswordByUserId(userId))) {
                response.setStatus(400);
                return Result.error(620, "旧密码错误");
            }
            userService.alterPassword(userId, alterPasswordForm.getNewPassword());
            return new Result(200, "密码修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(621, "修改密码失败");
        }
    }

    @RequestMapping(value = "/upload/{type}", method = RequestMethod.POST)
    public Result identityPicture(@RequestBody MultipartFile[] file, @PathVariable("type") int type) {
        if (file == null) {
            return Result.error(610, "上传失败");
        }
        List<String> filesName = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(webUploadPath);
        if(type == 0) {
            stringBuilder.append("/icon");
        }
        if(type == 1){
            stringBuilder.append("/verify");
        }
        String localPath = stringBuilder.toString();
        for (int i = 0; i < file.length; i++) {
            int begin = file[i].getOriginalFilename().indexOf(".");
            int last = file[i].getOriginalFilename().length();
            String fileName = UuidUtil.getUUID() + file[i].getOriginalFilename().substring(begin, last);
            if (FileUtil.upload(file[i], localPath, fileName)) {
                filesName.add(fileName);
            } else {
                response.setStatus(500);
                return Result.error(610, "上传图片失败");
            }
        }
        Map<String, Object> pictureName = new HashMap<>();
        pictureName.put("fileName", filesName);
        return new Result(200, "上传图片成功", pictureName);
    }

    @RequestMapping(value = "/verify/{userId}", method = RequestMethod.POST)
    public Result identity(@RequestBody IdentityForm identityForm, @PathVariable("userId") int userId) {
        try {
            userService.uploadIdentityInfo(identityForm, userId);
            return new Result(200, "上传身份验证信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(622, "提交身份验证信息失败");
        }
    }

    @RequestMapping(value = "/identity/{userId}", method = RequestMethod.PUT)
    public Result alteridentity(@RequestBody int identity, @PathVariable("userId") int userId) {
        try {
            if (userService.getUserVerifyInfo(userId)) {
                userService.setIdentity(identity, userId);
                return new Result(200, "身份更改成功");
            }
            response.setStatus(400);
            return Result.error(623, "请先进行身份认证");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(624, "身份更改失败");
        }
    }

    @RequestMapping(value = "/identity/{userId}", method = RequestMethod.GET)
    public Result getIdentity(@PathVariable("userId") int userId) {
        try {
            Map<String, Object> identity = new HashMap<>();
            identity.put("identity", userService.getUserIdentity(userId));
            identity.put("verify", userService.getUserVerifyInfo(userId));
            return new Result(200, "返回身份信息成功", identity);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(625, "返回身份信息失败");
        }
    }

    @RequestMapping(value = "/item/{userId}",method = RequestMethod.POST)
    public Result commitItem(@PathVariable("userId")int userId, @RequestBody @Valid ItemForm itemForm){
        try {
            itemService.commitItem(itemForm,userId);
            return new Result(200,"项目提交成功");
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(626,"项目提交失败");
        }
    }
}