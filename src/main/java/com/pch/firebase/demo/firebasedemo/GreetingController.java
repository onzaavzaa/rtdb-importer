package com.pch.firebase.demo.firebasedemo;

import com.google.firebase.database.*;
import com.pch.firebase.demo.firebasedemo.adapter.FirebaseRTDBAdapter;
import com.pch.firebase.demo.firebasedemo.repository.UserRepository;
import com.pch.firebase.demo.firebasedemo.rtdb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    FirebaseRTDBAdapter firebaseRTDBAdapter;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/createUser")
    public String greeting() {
        try {
/*            List<User> users = new ArrayList<>();
            User user = null;
            for (int i=0 ; i < 15 ; i++) {
                user = new User();
                user.setEmail("jfdguihudsgh");
                user.setUsername("UYIUI"+ new Date());
                user.setProfile_picture("jugvbsjbsm");

                users.add(user);

                System.out.println( i+" : " );
                i++;
            }

            userRepository.saveAll(users);*/

            double hh = 125.56985;
            firebaseRTDBAdapter.getDbRef().addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int i=1;
                    List<Order> orders = new ArrayList<>();
                    Order order = null;
                    for (DataSnapshot child : dataSnapshot.getChildren()) {

                        try {
                            order = child.getValue(Order.class);
                            orders.add(order);
                        }catch (DatabaseException e){
                            e.printStackTrace();
                        }

                        i++;
                    }
                    orders.size();
                    System.out.println("Start save: "+ new Date());

                    System.out.println("Save done: "+ new Date());
                    orders.clear();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println(databaseError.getDetails());
                }
            });

            System.out.println("------- Done.");  // "[DEFAULT]"

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "greeting";
    }

}