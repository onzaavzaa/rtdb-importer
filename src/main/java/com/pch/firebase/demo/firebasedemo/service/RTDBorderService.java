package com.pch.firebase.demo.firebasedemo.service;

import com.google.firebase.database.*;
import com.pch.firebase.demo.firebasedemo.adapter.FirebaseRTDBAdapter;
import com.pch.firebase.demo.firebasedemo.entity.TrOrderHEntity;
import com.pch.firebase.demo.firebasedemo.rtdb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RTDBorderService {

    @Autowired
    private FirebaseRTDBAdapter firebaseRTDBAdapter;

    public void updateOrderDateWhenCompleteImport(List<TrOrderHEntity> trOrderHEntities){

        for (TrOrderHEntity hEntity: trOrderHEntities){
            DatabaseReference orderRef= firebaseRTDBAdapter.getDbRefOrder();
            orderRef.orderByChild("orderCode")
                    .equalTo(hEntity.getTohCode());

            Map<String, Object> updateDate = new HashMap<>();
            updateDate.put("updateDate", "Sat Mar 28 2020 08:41:43 GMT+0700 (Indochina Time)");

            orderRef.updateChildrenAsync(updateDate);
        }


    }

    public Order findOrderById(String orderId){
        DatabaseReference reference= firebaseRTDBAdapter.getDbRefOrder();
        reference.orderByChild("orderCode")
                .equalTo(orderId)
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    try {
                        Map<String, Object> updateDate = new HashMap<>();
                        updateDate.put("updateDate", "Sat Mar 28 2020 08:41:43 GMT+0700 (Indochina Time)");
                        child.getRef().updateChildrenAsync(updateDate);
                    }catch (DatabaseException e){
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getDetails());
            }
        });

        return null;
    }
}
