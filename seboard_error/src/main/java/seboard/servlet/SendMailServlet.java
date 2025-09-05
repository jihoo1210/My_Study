package seboard.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
//import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/sendmail")
public class SendMailServlet extends HttpServlet {

	private static final String SMTP_HOST = "smtp.naver.com";
	private static final String SMTP_PORT = "587";
	private static final String SMTP_USER = "jihoo6398@naver.com";
	private static final String SMTP_PASS = "1M13BSZYM12W";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "홍길동";
		String fromEmail = SMTP_USER;
		String toEmail = "jihoo6398@gmail.com";
		String subject = "톰캣에서 알려드립니다.";
		String message = "이 이메일은 톰캣이 보내는 겁니다.";

		try {
			sendMail(name, fromEmail, toEmail, subject, message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void sendMail(String name, String fromEmail, String toEmail, String subject, String message)
			throws MessagingException, IOException {
		if (SMTP_USER == null || SMTP_PASS == null) {
			throw new MessagingException("SMTP_USER/SMTP_PASS 환경변수를 다시 확인하세요.");
		}

		// 동기화가 지원되는 HashMap | 키와 값이 모두 String 타입이어야 한다.
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // SMTP 인증 사용 여부
		props.put("mail.smtp.starttls.enable", "true"); // STARTTLS 프로토콜 활성화 여부
		// 평문(암호화되지 않은) 통신으로 시작한 연결을 암호화된 통신으로 업그레이드할지 결정하는 설정
		props.put("mail.smtp.host", SMTP_HOST); // SMTP 서버의 주소
		props.put("mail.smtp.port", SMTP_PORT); // SMTP 서버의 포트 번호

		Session session = Session.getInstance(props, new Authenticator() { // JavaMail에서 세션을 생성하는 정적(static) 팩토리 메서드
			// props: 이메일 서버에 연결하기 위한 속성(Properties) 객체
			// Authenticator: 이메일 서버 인증을 위한 추상 클래스
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// PasswordAuthentication: 사용자 이름과 비밀번호를 캡슐화하는 클래스입니다.
				//  서버 인증에 필요한 자격 증명(credentials)을 안전하게 전달하기 위해 사용
				return new PasswordAuthentication(SMTP_USER, SMTP_PASS);
				// SMTP_USER와 SMTP_PASS 상수에 저장된 아이디와 비밀번호를 사용하여
				// new PasswordAuthentication(SMTP_USER, SMTP_PASS)를 생성하고 반환
			}
		});

		// 이메일 메시지를 생성하기 위한 기본 환경 정보를 제공합니다.
		MimeMessage msg = new MimeMessage(session);

		// 수신자 설정
		// Message.RecipientType.TO: 수신자의 유형을 나타냅 | 변수에 저장된 이메일 주소 문자열을 Address 배열 타입으로
		// 변환
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

		// 발신자 설정
		msg.setFrom(new InternetAddress(SMTP_USER, "관리자", "UTF-8"));

		// 회신주소 설정 | 이메일 수신자가 "답장" 버튼을 눌렀을 때 실제로 메일이 보내질 주소
		msg.setReplyTo(new Address[] { new InternetAddress(fromEmail, name, "UTF-8") });

		// 제목 설정
		msg.setSubject(subject, "UTF-8");

		// 본문
		// MimeBodyPart textPart = new MimeBodyPart(); 파일첨부 없음
		String html = "<h1>새 메일이 도착했습니다.</h1><p>" + message + "</p>";
		msg.setContent(html, "text/html; charset=UTF-8");

		// 파일첨부 --- 생략

		Transport.send(msg);
		/*
		 * 1. 연결 설정: Session 객체에 설정된 정보(props)를 사용하여 SMTP 서버와 연결을 맺습니다.
		 * 2. 인증: 필요에 따라 Authenticator 객체를 통해 얻은 자격 증명으로 서버에 로그인합니다.
		 * 3. 메시지 전송: MimeMessage 객체에 담긴 이메일 내용(수신자, 제목, 본문 등)을 SMTP 프로토콜에 맞게 변환하여 서버로
		 * 보냅니다.
		 * 4. 연결 종료: 전송이 완료되면 서버와의 연결을 종료합니다.
		 */
	}
}
