package com.example.emailApii.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to)
	{
	
		boolean f = false;
		//System.out.println("Preparing to send messages ...");
		//String message = "Hello,just for checking! i am sending an attachment";
		//String subject = "not important : checking";
		//String to = "ishitadhar_d@srmuniv.edu.in";
		String from = "ishitadhar27@gmailcom";
		
		
		
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		
		
		// TODO Auto-generated method stub
		
		//host set
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//to get the session object

		Session session = Session.getInstance(properties, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("ishitadhar27@gmail.com", "2798ishitadhar");
				
				
			}
			
			
			
			
				});
		//step2 : compose the message[text,multi media]

		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		
		try
		{
			//from 
			m.setFrom(from);
			
			//adding recipient
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//set text
			m.setText(message);
			
			//step 3: send the message using transport class
			
			Transport.send(m);
			
			System.out.println("Sent successfully.......");
			
			f=true;
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return f;
		
	}	
}
		//sendEmail(message,subject,to,from);
		//sendAttach(message,subject,to,from);
				
	

	/*private static void sendAttach(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		
String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		
		
		// TODO Auto-generated method stub
		
		//host set
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//to get the session object

		Session session = Session.getInstance(properties, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("ishitadhar27@gmail.com", "2798ishitadhar");//hide the password.
				
				
			}
			
			
			
			
				});
		//step2 : compose the message[text,multi media]

		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		
		try
		{
			//from 
			m.setFrom(from);
			
			//adding recipient
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//set text
			//m.setText(message);
			
			
			//file path
			String path ="C:\\Users\\Ishita\\Downloads\\pup.jpg";
			
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			
			MimeBodyPart textMime = new MimeBodyPart();
			
			 MimeBodyPart fileMime = new MimeBodyPart();
			 
			 try
			 {
				 textMime.setText(message);
				 File file = new File(path);
				 fileMime.attachFile(file);
				 
				 mimeMultipart.addBodyPart(textMime);
				 mimeMultipart.addBodyPart(fileMime);
				 
			 } catch(Exception e)
			 {
				 e.getStackTrace();
			 }
			
			 
			//step 3: send the message using transport class
			
		
				m.setContent(mimeMultipart);
				Transport.send(m);
			
			System.out.println("Sent successfully.......");
			f= false;
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	
		
	}

	/*private static void sendEmail(String message, String subject, String to, String from) {
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		
		
		// TODO Auto-generated method stub
		
		//host set
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//to get the session object

		Session session = Session.getInstance(properties, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("ishitadhar27@gmail.com", "2798ishitadhar");
				
				
			}
			
			
			
			
				});
		//step2 : compose the message[text,multi media]

		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		
		try
		{
			//from 
			m.setFrom(from);
			
			//adding recipient
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//set text
			m.setText(message);
			
			//step 3: send the message using transport class
			
			Transport.send(m);
			
			System.out.println("Sent successfully.......");
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
	}*/


