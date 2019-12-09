package furryweb.example.Controller;

import furryweb.example.Model.*;
import furryweb.example.Service.MailService;
import furryweb.example.Service.UserService;
import furryweb.example.Util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by Administrator on 2019/9/29.
 */
@RequestMapping(value ="/api")
@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @Autowired
    private MailService mailService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@Valid @RequestBody LoginForm loginForm, HttpServletResponse response)  {
        int userId = userservice.CheckLogin(loginForm.getAccount(), loginForm.getPassword());
        if (userId == -1) {
            response.setStatus(400);
            return Result.error(301, "账号或密码错误");
        }
        Map<String, Object> m = new HashMap();
        m.put("userId", userId);
        response.setHeader("refresh_token", JwtUtil.createRefreshJavaWebToken(m));
        response.setHeader("access_token",JwtUtil.createAccessJavaWebToken(m));
        return new Result(200,"登录成功");
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@Valid @RequestBody RegisterForm u, HttpServletResponse response) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        if (userservice.findUserByAccount(u.getAccount())) {
            response.setStatus(400);
            return Result.error(401, "账号已被注册");
        }
        if(mailService.getEmailCheckCode(u.getEmail())==null){
            response.setStatus(400);
            return Result.error(402,"请进行邮箱验证");
        }
        if(!userservice.CheckRegisterByEmail(u.getEmail())){
            response.setStatus(400);
            return Result.error(406,"邮箱已被注册");
        }
        if(!u.getCheckCode().equals(mailService.getEmailCheckCode(u.getEmail()))){
            response.setStatus(400);
            return Result.error(403,"验证码不正确");
        }
        if(currentTime.after(mailService.getCheckExpireTime(u.getEmail()))){
            response.setStatus(400);
            return Result.error(404,"验证码已过期，请重新进行邮箱验证");
        }
        UserInfoEntity user = new UserInfoEntity(u.getAccount(),u.getPassword(),u.getName(),u.getEmail());
        userservice.Register(user);
        return new Result(200,"注册成功");
    }

    //获取验证码
    @RequestMapping(value = "/getCheckCode",method = RequestMethod.POST)
    public Result getCheckCode(@Valid @RequestBody EmailCheckForm email, HttpServletResponse response) {
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的验证码为：" + checkCode;
        try {
            mailService.sendSimpleMail(email.getEmail(), "验证码", message);
            if(mailService.haveEmailCheckCode(email.getEmail())){
                Timestamp updateTime = new Timestamp(System.currentTimeMillis());
                Timestamp expireTime = new Timestamp(updateTime.getTime()+60*60*1000);
                EmailCheckEntity emailCheckEntity = new EmailCheckEntity(email.getEmail(),checkCode,updateTime,expireTime);
                mailService.postEmailCheckCode(emailCheckEntity);
            }
            Timestamp updateTime = new Timestamp(System.currentTimeMillis());
            Timestamp expireTime = new Timestamp(updateTime.getTime()+60*60*1000);
            EmailCheckEntity emailCheckEntity = new EmailCheckEntity(email.getEmail(),checkCode,updateTime,updateTime,expireTime);
            mailService.postEmailCheckCode(emailCheckEntity);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(407,"验证码发送失败");
        }
        return new Result(200,"验证码发送成功");
    }

    @RequestMapping(value = "/retrievePassword",method = RequestMethod.POST)
    public Result retrievePassword(@RequestBody retrievePasswordByEmailForm rpByEmailForm,HttpServletResponse response){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        if(!userservice.findUserByAccount(rpByEmailForm.getAccount())){
            response.setStatus(400);
            return Result.error(410,"账号不存在");
        }
        if(!rpByEmailForm.getCheckCode().equals(mailService.getEmailCheckCode(userservice.getEmailByUserAccount(rpByEmailForm.getAccount())))){
            response.setStatus(400);
            return Result.error(403,"验证码不正确");
        }
        if(currentTime.after(mailService.getCheckExpireTime(userservice.getEmailByUserAccount(rpByEmailForm.getAccount())))){
            response.setStatus(400);
            return Result.error(404,"验证码已过期，请重新进行邮箱验证");
        }
        userservice.retrievePassword(rpByEmailForm.getAccount(),rpByEmailForm.getPassword());
        return new Result(200,"密码修改成功");
    }

    @RequestMapping(value = "/checkaccount",method = RequestMethod.POST)
    public Result checkAccount(@RequestBody String account,HttpServletResponse response){
        if(!userservice.findUserByAccount(account)){
            response.setStatus(400);
            return Result.error(410,"账号不存在");
        }
        String userEmail = userservice.getEmailByUserAccount(account);
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的验证码为：" + checkCode;
        try {
            mailService.sendSimpleMail(userEmail, "验证码", message);
            if(mailService.haveEmailCheckCode(userEmail)){
                Timestamp updateTime = new Timestamp(System.currentTimeMillis());
                Timestamp expireTime = new Timestamp(updateTime.getTime()+60*60*1000);
                EmailCheckEntity emailCheckEntity = new EmailCheckEntity(userEmail,checkCode,updateTime,expireTime);
                mailService.postEmailCheckCode(emailCheckEntity);
            }
            Timestamp updateTime = new Timestamp(System.currentTimeMillis());
            Timestamp expireTime = new Timestamp(updateTime.getTime()+60*60*1000);
            EmailCheckEntity emailCheckEntity = new EmailCheckEntity(userEmail,checkCode,updateTime,updateTime,expireTime);
            mailService.postEmailCheckCode(emailCheckEntity);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            return Result.error(407,"验证码发送失败");
        }
        return new Result(200,"验证码发送成功");
    }
}