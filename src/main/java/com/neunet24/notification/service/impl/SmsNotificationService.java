package com.neunet24.notification.service.impl;

import org.springframework.stereotype.Service;

import com.neunet24.notification.service.NotificationService;

@Service("sms")
public class SmsNotificationService implements NotificationService {

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub
		System.out.println("Sending SMS: "+message);
	}

}
