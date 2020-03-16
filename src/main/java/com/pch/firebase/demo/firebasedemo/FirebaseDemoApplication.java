package com.pch.firebase.demo.firebasedemo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;
import com.pch.firebase.demo.firebasedemo.rtdb.model.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.FileInputStream;

@SpringBootApplication
@EnableAsync
public class FirebaseDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirebaseDemoApplication.class, args);

	}


}
