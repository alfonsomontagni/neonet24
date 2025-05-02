package com.neunet24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.neunet24.notification.core.NotificationManager;

@SpringBootApplication
public class Neunet24Application {

	public static void main(String[] args) {
	ApplicationContext context =	SpringApplication.run(Neunet24Application.class, args);
		
		
		var manager = context.getBean(NotificationManager.class);
		manager.sendNotification("this is a test");
	}

}
