package furryweb.example.Service;

import furryweb.example.Dao.EmailCheckRepository;
import furryweb.example.Model.EmailCheckEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2019/10/22.
 */
@Service("mailService")
public class MailService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailCheckRepository emailCheckRepository;

    //向邮箱发送邮件
    public void sendSimpleMail(String to,String title,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);;
    }

    public Timestamp getCheckExpireTime(String user_email){
        EmailCheckEntity emailCheck = emailCheckRepository.findByUserEmail(user_email);
        if(emailCheck==null){
            return null;
        }
        return emailCheck.getExpireTime();
    }
    //从邮箱验证表中获取传入的邮箱的验证码
    public String getEmailCheckCode(String user_email){
        EmailCheckEntity emailCheck = emailCheckRepository.findByUserEmail(user_email);
        if(emailCheck==null){
            return null;
        }
        return emailCheck.getUserCode();
    }

    //判断传入的邮箱是否已经在邮箱验证表中
    public boolean haveEmailCheckCode(String user_email){
        EmailCheckEntity emailCheck = emailCheckRepository.findByUserEmail(user_email);
        if(emailCheck==null){
            return false;
        }
        return true;
    }

    //传入邮箱验证表
    public void postEmailCheckCode(EmailCheckEntity emailCheckEntity){
        emailCheckRepository.save(emailCheckEntity);
    }
}