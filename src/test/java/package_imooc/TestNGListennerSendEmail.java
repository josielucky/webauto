package package_imooc;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IExecutionListener;

public class TestNGListennerSendEmail implements IExecutionListener {
    public void onExecutionStart(){
        System.out.println("所有case开始执行");
    }
    public void onExecutionFinish(){
        HtmlEmail mail = new HtmlEmail();
        mail.setHostName("smtp.163.com");
        //  邮箱服务器身份验证 这里使用授权码，而不是邮箱原来的密码
        mail.setAuthentication("16620816949@163.com","NJJECOUWLYYBFEBX");
        try {
            // 发件人邮箱
            mail.setFrom("16620816949@163.com");
            // 收件人邮箱
            mail.addTo("josielucky@126.com");
            // 邮件主题
            mail.setSubject("selenium web_auto");
            mail.setCharset("utf-8");
            mail.setMsg("test");
            // 邮件内容
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

}
