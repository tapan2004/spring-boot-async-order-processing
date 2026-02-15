package com.example.async.controller;

import com.example.async.dto.Order;
import com.example.async.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<String> processOrder(@RequestBody Order order) throws InterruptedException {
        orderService.processOrder(order); // synchronous

        // Run async in parallel
        CompletableFuture.allOf(
                orderService.notifyUser(order),
                orderService.assignVendor(order),
                orderService.packing(order),
                orderService.assignDeliveryPartner(order),
                orderService.dispatch(order)
        );

        return new ResponseEntity<>(
                "Order created successfully. TrackingId=" + order.getTrackingId(),
                HttpStatus.CREATED
        );
    }
}
