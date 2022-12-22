package imooc.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendFileMail {
    public void SendMail(){
        HtmlEmail mail = new HtmlEmail();
        mail.setHostName("smtp.163.com");
        mail.setAuthentication("16620816949@163.com","NJJECOUWLYYBFEBX");
        try {
            mail.setFrom("16620816949@163.com");
            mail.addTo("josielucky@126.com");
            mail.setSubject("selenium web_auto");
            mail.setCharset("utf-8");
            mail.setMsg("test");
            mail.setHtmlMsg("<a href=\"\"> 测试报告");
            EmailAttachment emailAttachment = new EmailAttachment();
            emailAttachment.setPath("E:\\Idea\\web_auto\\target\\allure-results\\fd721dc9-610c-4842-9f83-76eafa1089ed-container.json");
            emailAttachment.setName("report.html");
            emailAttachment.setDescription(EmailAttachment.ATTACHMENT);
            mail.attach(emailAttachment);
            mail.send();
        }catch (EmailException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        SendFileMail sendFileMail = new SendFileMail();
        sendFileMail.SendMail();
    }
}