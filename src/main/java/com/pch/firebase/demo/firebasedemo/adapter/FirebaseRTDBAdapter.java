package com.pch.firebase.demo.firebasedemo.adapter;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;
import com.pch.firebase.demo.firebasedemo.config.ApplicationPropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;



@Component
public class FirebaseRTDBAdapter {

    private DatabaseReference dbRef;
    private FirebaseDatabase database;

    @Autowired
    private ApplicationPropertyValue appPropertyValue;

    @PostConstruct
    public void init(){
        try {
            FileInputStream serviceAccount = new FileInputStream(appPropertyValue.getFireBaseKeyPath());

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(appPropertyValue.getRtdbUrl())
                    .build();

            FirebaseApp defaultApp = FirebaseApp.initializeApp(options);

            System.out.println(defaultApp.getName());

            // Retrieve services by passing the defaultApp variable...
            FirebaseAuth defaultAuth = FirebaseAuth.getInstance(defaultApp);
            this.database = FirebaseDatabase.getInstance(defaultApp);
            dbRef = database.getReference(appPropertyValue.getRtdbRefOrder());
            System.out.println("Initial Firebase RTDB  Done.");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public DatabaseReference getDbRef() {
        return dbRef;
    }

    public DatabaseReference getDbRefOrder() {
        return this.database.getReference(appPropertyValue.getRtdbRefOrder());
    }

    public DatabaseReference getOrderDbRef() {
        return database.getReference("/order");
    }
}
