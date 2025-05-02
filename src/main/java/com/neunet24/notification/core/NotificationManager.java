package com.neunet24.notification.core;

import org.springframework.stereotype.Service;

import com.neunet24.notification.service.NotificationService;

@Service
public class NotificationManager {
	private final NotificationService notificationService;

	public NotificationManager(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	public void sendNotification(String message) {
		notificationService.send(message);
	}

}
