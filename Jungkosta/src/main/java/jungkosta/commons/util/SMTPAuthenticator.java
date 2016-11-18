package jungkosta.commons.util;

import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends javax.mail.Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
       
        return new PasswordAuthentication("test1282@naver.com","test!@34"); 
        
    }
}