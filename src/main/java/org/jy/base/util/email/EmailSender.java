package org.jy.base.util.email;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    private final Logger logger = LoggerFactory.getLogger(EmailSender.class);
    @Autowired
    private JavaMailSender javaMailSender;

     @Value("${mail.fromMail.addr}")
     private String from;


    /**
     * 发送邮件
     * @param to			收件人地址
     * @param subject		邮件主题
     * @param content		邮件内容
     * @author lance
     */
    public boolean sender(String to, String subject, String content){
        if(StringUtils.isBlank(to)) {
            logger.error("邮件发送失败：收件人地址不能为空.");
            return false;
        }
        return sender(new String[]{to}, subject, content);
    }


    /**
     * sender message
     * @param to
     * @param subject
     * @param content
     * @return
     */
    public boolean sender(String[] to, String subject, String content){
        if(to == null || to.length == 0) {
            logger.error("批量邮件发送失败：收件人地址不能为空.");
            return false;
        }


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        try {
            javaMailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            logger.error("发送邮件错误：{}, TO:{}, Subject:{},Content:{}.", e, to, subject, content);
            return false;
        }
    }


}
