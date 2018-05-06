package com.wenqi.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的的工具类
 */
@Component
public class MailUtil {
    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String sender; //读取配置文件中的参数
    private static MailUtil mailUtil;
    @PostConstruct
    public void init() {
        mailUtil = this;
        mailUtil.mailSender = this.mailSender;
        mailUtil.sender = this.sender;
    }
    private MailUtil() {
    }
    private static JavaMailSender getJavaMailSender() {
        return mailUtil.mailSender;
    }
    private static String getSender() {
        return mailUtil.sender;
    }
    public static void sendMail(String to,String[] cc,String subject,String text) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(getSender());
        //"15560108972@sina.cn"
        //1319533492@qq.com
        message.setTo(to); //自己给自己发送邮件
        if(cc!=null){
            message.setCc(cc);
        }
        message.setSubject(subject);
        message.setText(text);
        getJavaMailSender().send(message);
        System.out.println("==============发送成功");
    }
    public static void sendMail(String to,String[] cc,String subject, String text,
                                      FileSystemResource file,String fileName) throws Exception {
        MimeMessage message = null;
        try {
            message = getJavaMailSender().createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(getSender());
            helper.setTo(to);
            if(cc!=null){
                helper.setCc(cc);
            }

            helper.setSubject(subject);
            helper.setText(text, true);
            helper.addAttachment(fileName,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getJavaMailSender().send(message);
        System.out.println("==============发送成功");
    }
}
