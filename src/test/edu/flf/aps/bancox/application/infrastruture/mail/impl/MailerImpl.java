package edu.flf.aps.bancox.application.infrastruture.mail.impl;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.infrastruture.mail.Mailer;
import edu.flf.aps.bancox.application.infrastruture.mail.Message;

@Service
public class MailerImpl implements Mailer {

	@Override
	public void send(Message msg) {
		// TODO: enviar email		
	}

}
