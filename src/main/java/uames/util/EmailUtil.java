package uames.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/*
 * 描述：用于发送电子邮件
 * 创建日期 2014-5-4 11:46
 * 作者 may
 */
public class EmailUtil {
	public static String userName=""; //发件人的邮箱地址
	public static String password=""; //发件人邮箱密码
	public static String smtpHost="smtp.ym.163.com";

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        EmailUtil.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        EmailUtil.password = password;
    }

    public static String getSmtpHost() {
        return smtpHost;
    }

    public static void setSmtpHost(String smtpHost) {
        EmailUtil.smtpHost = smtpHost;
    }

   /* 
	 * 发送电子邮件
	 * email 邮件地址
	 * subject 邮件标题
	 * content 邮件内容
	 
	@SuppressWarnings("static-access")
    public static Boolean sendMail(String email,String subject,String content)throws Exception{
	    MsgStatusPrc prc = new MsgStatusPrc();
        SmtpConfig  po = new SmtpConfig();
        po = prc.getSmtpConfig();
        password = po.getPassword();
        userName = po.getAccount();
        smtpHost = po.getSmtp_url();
        
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", getSmtpHost());
		props.put("mail.smtp.starttls.enable","true");//使用 STARTTLS安全连接 
		props.put("mail.smtp.auth", "true");        // 使用验证
		//props.put("mail.debug", "true");//在控制台开启调试
		Session session=Session.getInstance(props,  //初始化Session对象
				new EmailAuthenticator(userName,password));
		try{
		    if(!UamesUtil.IsNullOrWhiteSpace(userName)){
		        InternetAddress form=new InternetAddress(userName);
		        InternetAddress to=new InternetAddress(email);
		        MimeMessage message = new MimeMessage(session);  
		        message.setFrom(form);
		        message.addRecipient(RecipientType.TO, to); //设置收件人
		        message.setSentDate(new Date());
		        message.setSubject(subject); //发送标题
		        message.setContent(content, "text/html;charset=utf-8");     //发送内容
		        // 发送消息   
		        Transport transport = session.getTransport("smtp");  
		        transport.connect(smtpHost,userName, password);  
		        transport.send(message, message.getRecipients(RecipientType.TO));
		        return true;
		    }else{
		        return false;
		    }
		}catch(Exception e){
		    e.printStackTrace();
		    throw e; 
		}
	}
	
	public static void main(String[] args) {
		try{
			if(EmailUtil.sendMail("398746422@qq.com", "测试邮箱", "你的认证码是：")){
				   System.out.println("发送成功");
				}else{
					System.out.println("发送失败");
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
}

class EmailAuthenticator extends Authenticator{
	 String username=""; //发送邮件的用户名
	 String password="";//发送邮件的密码
	 
	 public EmailAuthenticator(){
		 
	 }
	 public EmailAuthenticator(String username,String password){
		 this.username=username;
		 this.password=password;
	 }
	 
	 protected PasswordAuthentication getPasswordAuthentication(){
		 return new PasswordAuthentication(username,password);
	 }
}
