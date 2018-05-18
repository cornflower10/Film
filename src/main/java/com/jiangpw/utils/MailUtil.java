package com.jiangpw.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil implements Runnable {
    private String email;// 收件人邮箱
    private String code;// 激活码
    private String title;
    private String content;
    public static final int JIHUO = 1;
    public static final int FINDPASSWD = 2;
    public static final int VIP_SUCCESS = 3;

    public MailUtil(String email, String code,int type) {
        this.email = email;
        this.code = code;

        switch (type){
            case JIHUO:
                title = "账号激活";
                content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
                        + code + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code=" + code
                        + "</href></h3></body></html>";
                break;
            case FINDPASSWD:
                title = "密码找回";
                content = "<html><head></head><body><h1>这是一封密码找回邮件,密码找回请点击以下链接</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
                        + code + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code=" + code
                        + "</href></h3></body></html>";
                break;
            case VIP_SUCCESS:
                title = "会员充值成功";
                content = "<html><head></head><body><h1>这是一封会员充值邮件，恭喜您已是会员请前往登录</h1></body></html>";
                break;
        }
    }

    public void run() {
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        String from = "861281331@qq.com";// 发件人电子邮箱
        String host = "smtp.qq.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)

        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);


            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("861281331@qq.com", "azykxjzyfwxabahg"); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject(title);
            // 2.4设置邮件内容

            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
