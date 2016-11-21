package jungkosta.main.controller;

import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jungkosta.commons.util.SMTPAuthenticator;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;

@RestController
public class SMTPController {
	
	@Inject
	private SignupService service;
	
	//SMTP 메일서버 메소드 
	@RequestMapping(value = "mainMailSendProc", method = RequestMethod.POST)
	public ResponseEntity<String> mainMailSendProc(
			@RequestParam("receiver") String receiver, HttpServletRequest request) throws Exception {
		
		ResponseEntity<String> entity = null;
		HttpSession session = request.getSession();
		
		try {

			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i <= 6; i++) {
				int n = (int) (Math.random() * 10);
				buffer.append(n);
			}
			
			String sender = "test1282@naver.com"; // 보내는 메일주소 구글로 입력해주세요.
			String subject = "JUNGKOSTA 회원가입 인증번호입니다. ";
			String content = "인증번호는 [" + buffer.toString() + "] 입니다. \n 인증번호를 사이트에 입력해서 인증을 완료하세요";

			MemberVO member = service.selectMemberService(receiver);

			String connum = buffer.toString();
			
			session.setAttribute("connum", connum);

			// 정보를 담기 위한 객체
			Properties p = new Properties();

			// SMTP 서버의 계정 설정
			// Naver와 연결할 경우 네이버 아이디 지정
			// Google과 연결할 경우 본인의 Gmail 주소
			/* p.put("mail.smtp.user", ".com"); */

			// SMTP 서버 정보 설정
			// 네이버일 경우 smtp.naver.com
			// Google일 경우 smtp.gmail.com
			p.put("mail.smtp.host", "smtp.naver.com");

			// 아래 정보는 네이버와 구글이 동일하므로 수정하지 마세요.
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");

			if (member == null) {
				Authenticator auth = new SMTPAuthenticator();
				Session ses = Session.getInstance(p, auth);

				// 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.
				ses.setDebug(true);

				// 메일의 내용을 담기 위한 객체
				MimeMessage msg = new MimeMessage(ses);

				// 제목 설정
				msg.setSubject(subject);

				// 보내는 사람의 메일주소
				Address fromAddr = new InternetAddress(sender);
				msg.setFrom(fromAddr);

				// 받는 사람의 메일주소
				Address toAddr = new InternetAddress(receiver);
				msg.addRecipient(Message.RecipientType.TO, toAddr);

				// 메시지 본문의 내용과 형식, 캐릭터 셋 설정
				msg.setContent(content, "text/html;charset=UTF-8");

				// 발송하기
				Transport.send(msg);

				entity = new ResponseEntity<String>("success", HttpStatus.OK);
				System.out.println(entity.getBody().toString());
			} else {
				entity = new ResponseEntity<String>("0", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//인증번호 확인 메소드
	@RequestMapping(value="confirmnumProc", method=RequestMethod.POST)
	public ResponseEntity<String> confirmnumProc(@RequestParam("number") String number,
			HttpServletRequest request){
		ResponseEntity<String> entity = null;
		
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("connum") != null){
				if(number.equals((String)session.getAttribute("connum"))){
					entity = new ResponseEntity<String>("1", HttpStatus.OK);
				}
				else
					entity = new ResponseEntity<String>("0", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//타임오바 세션제거
	@RequestMapping(value="expire_number", method=RequestMethod.POST)
	public ResponseEntity<String> timeOver(HttpServletRequest request){
		ResponseEntity<String> entity = null;
		HttpSession session = request.getSession();
		
		try {
			session.removeAttribute("connum");
			entity = new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
