package Utilities;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;

public class Mail0 {



	static Session newSession =null;
	MimeMessage mimemessage = null;

	public static void main(String args[]) throws AddressException,MessagingException,IOException
	{
		Mail mail = new Mail();
		mail.setupServerProperties();
		mail.draftEmail();
		mail.sendEmail();
	}



	private void sendEmail() { throws MessagingException {
		String fromUser ="dheerumech46@gmail.com";
		String emailHost="smtp.gmail.com";
		String fromUserPassword ="***";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		System.out.println("Email success");
	}

	private MimeMessage draftEmail() { throws AdressException,MessagingException IOException {
		// TODO Auto-generated method stub
		String[] emaiReceipients= {"dheerumech7@gmail.com","sonusunny5414@gmail.com"};
		String emailSubject="test Mail";
		String emailody="test body of my mail";
		mimeMessage=new MimeMessage(newSession);

		for (int i=0; i<emaiReceipients.length; i++) 
		{
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emaiReceipients[i]));
		}
		mineMessage.setSubject(emailSubject);
		MineMultipart multipart = new MineMultipart();


		MimeBodyPart bodypart = new MineBodyPart();
		bodyPart.setContent(emailBody,"html/text");
		MimeMultipart multipart = new MimeMultipart();
		mimeMessage.setContent(multiPart);
		return mimeMessage;

	}

	private void setupServerProperties() {
		// TODO Auto-generated method stub
		Properties properties = System.getProperties();
		properties.put("mail.smpt.port","547");
		properties.put("mail.smpt.auth","true");
		properties.put("mail.smpt.starttls.enable","true");
		newSession = Session.getDefaultInstance(properties,null);
	}





	}
