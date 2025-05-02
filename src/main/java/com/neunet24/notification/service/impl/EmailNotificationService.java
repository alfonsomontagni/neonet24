package com.neunet24.notification.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.neunet24.notification.service.NotificationService;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub
		System.out.println("Sending EMAIL: "+message);

	}

}
