package com.example.async.service;

import com.example.async.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private InventoryService service;
    @Autowired
    private PaymentService paymentService;

    public void processOrder(Order order) throws InterruptedException {
        order.setTrackingId(UUID.randomUUID().toString());
        if (!service.checkProductAvailability(order.getProductId())) {
            throw new RuntimeException("Product not available");
        }
        paymentService.processPayment(order);
        log.info("Order processed successfully trackingId={}", order.getTrackingId());
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<Void> notifyUser(Order order) {
        try {
            Thread.sleep(4000);
            log.info("User notified | trackingId={} | thread={}",
                    order.getTrackingId(), Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("Error notifying user", e);
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async("asyncTaskExecutor")
    public  CompletableFuture<Void> assignVendor(Order order) {
        try {
            Thread.sleep(5000);
            log.info("Vendor assigned | trackingId={} | thread={}",
                    order.getTrackingId(), Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("Error assigning vendor", e);
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<Void> packing(Order order) {
        try {
            Thread.sleep(2000);
            log.info("Packing done | trackingId={} | thread={}",
                    order.getTrackingId(), Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("Error in packing", e);
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<Void> assignDeliveryPartner(Order order) {
        try {
            Thread.sleep(10000);
            log.info("Delivery partner assigned | trackingId={} | thread={}",
                    order.getTrackingId(), Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("Error assigning delivery partner", e);
        }
        return CompletableFuture.completedFuture(null);
    }


    @Async("asyncTaskExecutor")
    public CompletableFuture<Void> dispatch(Order order) {
        try {
            Thread.sleep(3000);
            log.info("Order dispatched | trackingId={} | thread={}",
                    order.getTrackingId(), Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("Error dispatching order", e);
        }
        return CompletableFuture.completedFuture(null);
    }
}
