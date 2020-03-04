package com.idempotent.util;

import com.idempotent.pojo.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-09-12 15:38
 */
@Component
public class MailUtil {

    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    @Value("${spring.mail.from}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单邮件
     */
    public boolean send(Mail mail) {
        // 目标邮箱
        String to = mail.getTo();
        // 邮件标题
        String title = mail.getTitle();
        // 邮件正文
        String content = mail.getContent();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);

        try {
            mailSender.send(message);
            logger.info("邮件发送成功");
            return true;
        } catch (MailException e) {
            logger.error("邮件发送失败, to: {}, title: {}", to, title, e);
            return false;
        }
    }

    /**
     * 发送附件邮件
     */
    public boolean sendAttachment(Mail mail, File file) {
        String to = mail.getTo();
        String title = mail.getTitle();
        String content = mail.getContent();

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(content);
            FileSystemResource resource = new FileSystemResource(file);
            String fileName = file.getName();
            helper.addAttachment(fileName, resource);
            mailSender.send(message);
            logger.info("附件邮件发送成功");
            return true;
        } catch (Exception e) {
            logger.error("附件邮件发送失败, to: {}, title: {}", to, title, e);
            return false;
        }
    }
}
