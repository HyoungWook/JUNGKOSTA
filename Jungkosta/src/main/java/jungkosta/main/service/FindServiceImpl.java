package jungkosta.main.service;

import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.persistence.FindDao;

@Service
public class FindServiceImpl implements FindService {
	
	@Inject
	private FindDao findDao;
	
	public MemberVO findEmail(MemberVO vo)throws Exception{
		
		return findDao.findEmail(vo);
	}
	
	@Override
	public MemberVO findPassword(MemberVO vo) throws Exception {
		
		MemberVO retVo = findDao.findPassword(vo);
		
		if(retVo != null){
			sendEmail(retVo);
		}
		
		return retVo;
	}
	
	public void sendEmail(MemberVO vo){
		Properties p = new Properties(); // 정보를 담을 객체

	    p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP

	    p.put("mail.smtp.port", "465");
	    p.put("mail.smtp.auth", "true");
	    p.put("mail.smtp.debug", "true");
	    p.put("mail.smtp.socketFactory.port", "465");
	    p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    p.put("mail.smtp.socketFactory.fallback", "false");
		
		String email = vo.getEmail();
		String password = vo.getPassword();
		
		String content = "문의 하신 비밀번호는 : "+password+"입니다.";
		
		try{
			
			Session mailSession = Session.getInstance(p,
	                new javax.mail.Authenticator() {
	                  protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication("test1282@naver.com","test!@34");    // 네이버 메일 ID / PWD
	                  }
	                });
			
			mailSession.setDebug(true);
			
			Message message = new MimeMessage(mailSession);
			
			message.setFrom(new InternetAddress("test1282@naver.com"));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			
			message.setSubject("문의하신 비밀 번호 입니다");
			
			message.setContent(content, "text/html;charset=utf-8");
			
			Transport.send(message);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
