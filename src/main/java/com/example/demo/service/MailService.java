package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * yangjiahao: demo
 * Created by yjh on 2020/4/26 22:11
 */
@Service
public interface MailService{

    /**
     * 发送文本邮件,注册部分用不到
     * @param to
     * @param subject
     * @param content
     */
    //void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件，方便用户点击附带的code用来验证激活账户
     * @param to
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);
}
