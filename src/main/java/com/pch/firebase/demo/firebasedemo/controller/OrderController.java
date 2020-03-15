package com.pch.firebase.demo.firebasedemo.controller;

import com.google.common.collect.Lists;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.ValueEventListener;
import com.pch.firebase.demo.firebasedemo.FirebaseRTDBAdapter;
import com.pch.firebase.demo.firebasedemo.entity.*;
import com.pch.firebase.demo.firebasedemo.mapper.OrderEntityMapper;
import com.pch.firebase.demo.firebasedemo.repository.OrderItemRepository;
import com.pch.firebase.demo.firebasedemo.repository.OrderRepository;
import com.pch.firebase.demo.firebasedemo.repository.TrOrderDRepository;
import com.pch.firebase.demo.firebasedemo.repository.TrOrderHRepository;
import com.pch.firebase.demo.firebasedemo.service.AsyncOrderDetailService;
import com.pch.firebase.demo.firebasedemo.service.AsyncOrderHeadService;
import com.pch.firebase.demo.firebasedemo.service.AsyncSave;
import com.pch.firebase.demo.firebasedemo.service.RTDBorderService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class OrderController {

    private int importedRows = 0;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private TrOrderHRepository trOrderHeadRepository;
    @Autowired
    private TrOrderDRepository trOrderDetailRepository;
    @Autowired
    private FirebaseRTDBAdapter firebaseRTDBAdapter;
    @Autowired
    private OrderEntityMapper orderEntityMapper;
    @Autowired
    private AsyncSave asyncSave;
    @Autowired
    private AsyncOrderHeadService asyncOrderHeadService;
    @Autowired
    private AsyncOrderDetailService asyncOrderDetailService;
    @Autowired
    private RTDBorderService rtdBorderService;

    @GetMapping("/createOrder")
    public String createOrder() {

        Order order = new Order();
        OrderItem orderItem = new OrderItem();

        OrderItemId orderItemId = new OrderItemId();
        orderItemId.setOrderCode("7777");
        orderItemId.setProductCode("7777");
        orderItemId.setProductNumber("7777");
        orderItemId.setSeq(1L);

        orderItem.setAmount(12L);
        orderItem.setCreateBy("sdg");
        orderItem.setCreateDate(new Date());
        orderItem.setPrice(500L);
        orderItem.setQty(2L);
        orderItem.setUpdateBy("ddsf");
        orderItem.setUpdateDate(new Date());
        orderItem.setWinAmount(52L);
        orderItem.setWinRate(2L);
        orderItem.setWinStatus("s");
        orderItem.setOrderItemId(orderItemId);


        OrderId orderId = new OrderId();
        orderId.setRoundCode("vsdd");
        orderId.setOrderCode("7777");
        orderId.setCycleCode("fgsgs");
        orderId.setCustomerCode("fsef");

        order.setCreateBy("dsfgs");
        order.setCreateDate(new Date());
        //order.setCustomerName("fewg");
       // order.setCycleEndDate(new Date());
        order.setOrderStatus("sgse");
        order.setOrderTotal(54L);
        order.setOrderSeq(54L);
        //order.setRoundName("gewg");
        order.setWinStatus("gsaegew");
        //order.setWinTotal(9L);
        order.setUpdateBy("dgfe");
        order.setUpdateDate(new Date());

        order.setOrderId(orderId);

        orderRepository.save(order);
        orderItemRepository.save(orderItem);

        return "Done";
    }

    @GetMapping("/createOrder/single/{rowQty}")
    public String createOrder2(@PathVariable Map<String, String> vals) {

        int rowQty = Integer.parseInt(vals.get("rowQty"));

        List<TrOrderHEntity> trOrderHEntities = new ArrayList<>();
        List<TrOrderDEntity> trOrderDEntities = new ArrayList<>();
        for(int i =1; i< rowQty; i++){
            String orderCode = UUID.randomUUID().toString();
            TrOrderHEntity trOrderHEntity = new TrOrderHEntity();
            trOrderHEntity.setMrdCode("rghftg");
            trOrderHEntity.setTcrCode("gwse");
            trOrderHEntity.setTohCode(orderCode);
            trOrderHEntity.setTohCreateBy("juhv");
            trOrderHEntity.setTohCreateDate(new Timestamp(new Date().getTime()));
            trOrderHEntity.setTohCustomerCode("brsdh");
            trOrderHEntity.setTohSeq(1);
            trOrderHEntity.setTohStatus("bndrjn");
            trOrderHEntity.setTohTotal(3);
            trOrderHEntity.setTohUpdateBy("ndtj");
            trOrderHEntity.setTohUpdateDate(new Timestamp(new Date().getTime()));
            trOrderHEntity.setTohWinStatus("rhrt");

            trOrderHEntities.add(trOrderHEntity);


            TrOrderDEntity orderDEntity = new TrOrderDEntity();
            orderDEntity.setMpdCode("tttt");
            orderDEntity.setTodAmount(3);
            orderDEntity.setTodCreateBy("rhreh");
            orderDEntity.setTodCreateDate(new Timestamp(new Date().getTime()));
            orderDEntity.setTodNumber("p");
            orderDEntity.setTodPrice(2);
            orderDEntity.setTodQty(1);
            orderDEntity.setTodSeq(1);
            orderDEntity.setTodUpdateBy("gwe");
            orderDEntity.setTodUpdateDate(new Timestamp(new Date().getTime()));
            orderDEntity.setTodWinAmount(3);
            orderDEntity.setTodWinRate(5);
            orderDEntity.setTodWinStatus("gherswg");
            orderDEntity.setTohCode(orderCode);

            trOrderDEntities.add(orderDEntity);


        }

        System.out.println("trOrderHEntities: "+ trOrderHEntities.size());
        System.out.println("trOrderDEntities: "+ trOrderDEntities.size());
        System.out.println("Start save: "+ new Date());
        trOrderHeadRepository.saveAll(trOrderHEntities);
        trOrderDetailRepository.saveAll(trOrderDEntities);
        System.out.println("Complete save: "+ new Date());

        return "Done";
    }

    @GetMapping("/createOrder/multi/{rowQty}")
    public String createOrderMultithread(@PathVariable Map<String, String> vals) throws InterruptedException {

        int rowQty = Integer.parseInt(vals.get("rowQty"));


        List<TrOrderHEntity> trOrderHEntities = new ArrayList<>();
        List<TrOrderDEntity> trOrderDEntities = new ArrayList<>();
        for(int i =1; i< rowQty; i++){
            String orderCode = UUID.randomUUID().toString();
            TrOrderHEntity trOrderHEntity = new TrOrderHEntity();
            trOrderHEntity.setMrdCode("rghftg");
            trOrderHEntity.setTcrCode("gwse");
            trOrderHEntity.setTohCode(orderCode);
            trOrderHEntity.setTohCreateBy("juhv");
            trOrderHEntity.setTohCreateDate(new Timestamp(new Date().getTime()));
            trOrderHEntity.setTohCustomerCode("brsdh");
            trOrderHEntity.setTohSeq(1);
            trOrderHEntity.setTohStatus("bndrjn");
            trOrderHEntity.setTohTotal(3);
            trOrderHEntity.setTohUpdateBy("ndtj");
            trOrderHEntity.setTohUpdateDate(new Timestamp(new Date().getTime()));
            trOrderHEntity.setTohWinStatus("rhrt");

            trOrderHEntities.add(trOrderHEntity);


            TrOrderDEntity orderDEntity = new TrOrderDEntity();
            orderDEntity.setMpdCode("tttt");
            orderDEntity.setTodAmount(3);
            orderDEntity.setTodCreateBy("rhreh");
            orderDEntity.setTodCreateDate(new Timestamp(new Date().getTime()));
            orderDEntity.setTodNumber("p");
            orderDEntity.setTodPrice(2);
            orderDEntity.setTodQty(1);
            orderDEntity.setTodSeq(1);
            orderDEntity.setTodUpdateBy("gwe");
            orderDEntity.setTodUpdateDate(new Timestamp(new Date().getTime()));
            orderDEntity.setTodWinAmount(3);
            orderDEntity.setTodWinRate(5);
            orderDEntity.setTodWinStatus("gherswg");
            orderDEntity.setTohCode(orderCode);

            trOrderDEntities.add(orderDEntity);


        }

        List<List<TrOrderHEntity>> trOrderHEntitiesAsPartition = new ArrayList<>();
        List<List<TrOrderDEntity>> trOrderDEntitiesAsPartition = new ArrayList<>();

        trOrderHEntitiesAsPartition = Lists.partition(trOrderHEntities, 100);
        trOrderDEntitiesAsPartition = Lists.partition(trOrderDEntities, 100);

        List<CompletableFuture<String>> completableFutures = new ArrayList<>();
        for(List<TrOrderHEntity> orderHEntities:trOrderHEntitiesAsPartition) { // Use this to loop List partition
            CompletableFuture<String> futureTask = asyncOrderHeadService.saveAll(orderHEntities);
            completableFutures.add(futureTask);
        }

        for(List<TrOrderDEntity> orderDEntities:trOrderDEntitiesAsPartition){
            CompletableFuture<String> futureTask = asyncOrderDetailService.saveAll(orderDEntities);
            completableFutures.add(futureTask);
        }

        System.out.println("Start save: "+ new Date());
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));


        return "Done";
    }

    @RequestMapping(
            value = {"/importRTDB/order","/importRTDB/order/{createDate}"},
            method = GET,
            produces = { "application/json" }
    )
    @ResponseBody
    public String importRTDB(@PathVariable Map<String, String> vals) throws ParseException {

        String queryDateStr = vals.get("createDate");
        SimpleDateFormat queryDf = new SimpleDateFormat("yyyy-MM-dd");
        queryDf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date queryDate = null;
        if(StringUtils.isEmpty(queryDateStr)){
            queryDate = new Date();
        }else{
            queryDate = queryDf.parse(queryDateStr);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String currentDate = sdf.format(queryDate);

        firebaseRTDBAdapter.getDbRef()
                .orderByChild("createDate")
                .startAt(currentDate)
                .endAt(currentDate+"\\uf8ff")
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @SneakyThrows
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                importedRows = 0;
                int i=1;
                List<com.pch.firebase.demo.firebasedemo.rtdb.model.Order> orders = new ArrayList<>();
                com.pch.firebase.demo.firebasedemo.rtdb.model.Order order = null;
                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    try {
                        order = child.getValue(com.pch.firebase.demo.firebasedemo.rtdb.model.Order.class);
                        orders.add(order);

                        Map<String, Object> updateDate = new HashMap<>();
                        updateDate.put("updateDate", "Sat Mar 28 2020 08:41:43 GMT+0700 (Indochina Time)");
                        child.getRef().updateChildrenAsync(updateDate);

                    }catch (DatabaseException e){
                        e.printStackTrace();
                    }

                    i++;
                }
                importedRows = orders.size();
                if(importedRows>0){
                    orderEntityMapper.map(orders);
                    List<TrOrderHEntity> trOrderHEntities = orderEntityMapper.getOrderHeadEntities();
                    List<TrOrderDEntity> trOrderDEntities = orderEntityMapper.getOrderDetailEntities();

                    List<List<TrOrderHEntity>> trOrderHEntitiesAsPartition = new ArrayList<>();
                    List<List<TrOrderDEntity>> trOrderDEntitiesAsPartition = new ArrayList<>();

                    trOrderHEntitiesAsPartition = Lists.partition(trOrderHEntities, 100);
                    trOrderDEntitiesAsPartition = Lists.partition(trOrderDEntities, 100);

                    List<CompletableFuture<String>> completableFutures = new ArrayList<>();
                    for(List<TrOrderHEntity> orderHEntities:trOrderHEntitiesAsPartition) { // Use this to loop List partition
                        CompletableFuture<String> futureTask = asyncOrderHeadService.saveAll(orderHEntities);
                        completableFutures.add(futureTask);
                    }

                    for(List<TrOrderDEntity> orderDEntities:trOrderDEntitiesAsPartition){
                        CompletableFuture<String> futureTask = asyncOrderDetailService.saveAll(orderDEntities);
                        completableFutures.add(futureTask);
                    }

                    System.out.println("Start save: "+ new Date());
                    CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                            .thenApply(v -> completableFutures.stream()
                                    .map(CompletableFuture::join)
                                    .collect(Collectors.toList()));

                    System.out.println("Save done: "+ new Date());
                    orders.clear();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getDetails());
            }
        });

        System.out.println("------- Done.");

        return "Done.";
    }

    @GetMapping("/findRtdbOrderById/{orderId}")
    public String findRTDBBYID(@PathVariable String orderId){

        rtdBorderService.findOrderById(orderId);

        return "Done";
    }

    @GetMapping("/updateOrderByCode/{orderCode}")
    public String updateOrderByCode(@PathVariable String orderCode){
        List<TrOrderHEntity> trOrderHEntities = new ArrayList<>();
        TrOrderHEntity trOrderHEntity = new TrOrderHEntity();
        trOrderHEntity.setMrdCode("rghftg");
        trOrderHEntity.setTcrCode("gwse");
        trOrderHEntity.setTohCode(orderCode);
        trOrderHEntity.setTohCreateBy("juhv");
        trOrderHEntity.setTohCreateDate(new Timestamp(new Date().getTime()));
        trOrderHEntity.setTohCustomerCode("brsdh");
        trOrderHEntity.setTohSeq(1);
        trOrderHEntity.setTohStatus("bndrjn");
        trOrderHEntity.setTohTotal(3);
        trOrderHEntity.setTohUpdateBy("ndtj");
        trOrderHEntity.setTohUpdateDate(new Timestamp(new Date().getTime()));
        trOrderHEntity.setTohWinStatus("rhrt");

        trOrderHEntities.add(trOrderHEntity);
        rtdBorderService.updateOrderDateWhenCompleteImport(trOrderHEntities);

        return "Done";
    }
}
