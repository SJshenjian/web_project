package online.shenjian.xuefeng.service.impl;

import online.shenjian.xuefeng.mapper.VisitorMapper;
import online.shenjian.xuefeng.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shenjian.xuefeng.service.VisitorService;

@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorMapper visitorMapper;
	
	@Override
	public void contactMe(Visitor visitor) {
		visitorMapper.addContactMeInfo(visitor);
		
		SimpleMail simpleMail=new SimpleMail();
		simpleMail.sendSimpleMail(visitor);
		
	}

	/**简单邮件发送**/
	//沈健5.16
	private class SimpleMail{
		
		public void sendSimpleMail(Visitor visitor){
			
			//定义发送消息
			SimpleMailMessage message=new SimpleMailMessage();
			
			message.setFrom("shenjian66666688@163.com");
			message.setTo("shenjian66666688@sina.com");
			message.setSubject(visitor.getSubject());
			message.setText("发送者:"+visitor.getName()+"\n邮箱号:"+visitor.getEmail()+"\n文本内容:"+visitor.getContent());
			
			//邮件发送器配置
			JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
			
			mailSender.setHost("smtp.163.com");
			mailSender.setUsername("shenjian66666688");
			mailSender.setPassword("icanfly1314");
			
			mailSender.send(message);
			System.out.println("邮件发送成功");
		}	
	}
}
