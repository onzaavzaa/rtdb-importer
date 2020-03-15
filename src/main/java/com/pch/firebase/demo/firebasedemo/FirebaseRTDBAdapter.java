package com.pch.firebase.demo.firebasedemo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;



@Component
public class FirebaseRTDBAdapter {

    private DatabaseReference dbRef;
    private FirebaseDatabase database;

    public FirebaseRTDBAdapter() {
        try {
            FileInputStream serviceAccount = new FileInputStream("D:\\spring-java\\firebase-c\\firebase-key.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://myfirebase-c39e4.firebaseio.com")
                    .build();

            FirebaseApp defaultApp = FirebaseApp.initializeApp(options);

            System.out.println(defaultApp.getName());

            // Retrieve services by passing the defaultApp variable...
            FirebaseAuth defaultAuth = FirebaseAuth.getInstance(defaultApp);
            this.database = FirebaseDatabase.getInstance(defaultApp);
            dbRef = database.getReference("order");
            System.out.println("Initial Firebase RTDB  Done.");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public DatabaseReference getDbRef() {
        return dbRef;
    }

    public DatabaseReference getOrderDbRef() {
        return database.getReference("/order");
    }
}
