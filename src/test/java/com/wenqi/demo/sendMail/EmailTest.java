package com.wenqi.demo.sendMail;


import com.wenqi.demo.utils.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("163")
public class EmailTest {

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        //"15560108972@sina.cn"
        //1319533492@qq.com
        message.setTo("840657252@qq.com"); //自己给自己发送邮件
        message.setSubject("郊游");
        message.setText("周末去怎么样");
        mailSender.send(message);
        System.out.println("==============发送成功");
    }

    @Test
    public void sendHtmlMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo("840657252@qq.com");
            helper.setSubject("标题：发送Html内容");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo("1319533492@qq.com");
            helper.setSubject("主题：带附件的邮件");
            helper.setText("带附件的邮件内容");
            //注意项目路径问题，自动补用项目路径
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/images/真美.jpg"));
            //加入邮件
            helper.addAttachment("图片.jpg", file);
        } catch (Exception e){
            e.printStackTrace();
        }
        mailSender.send(message);
    }
    @Test
    public void test() throws Exception {
        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/images/user.png"));
        String[] cc={"15538103935@163.com","1319533492@qq.com"};
        MailUtil.sendMail("840657252@qq.com",cc,
                null,
                "<h1>大标题-h1</h1><p style='color:#F00'>红色字</p><p style='text-align:right'>右对齐</p>",
                file,"user.png");
    }
    @Test
    public void test2() throws Exception {
        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/images/user.png"));
        String[] cc={"15538103935@163.com","1319533492@qq.com"};
        MailUtil.sendMail("840657252@qq.com",cc,
                "追风筝的人",
                "逐渐逝去" );
    }
}