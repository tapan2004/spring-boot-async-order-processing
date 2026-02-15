package com.example.async.service;

import com.example.async.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {
    public void processPayment(Order order) throws InterruptedException {
        log.info("Payment started for productId={}", order.getProductId());
        Thread.sleep(2000);
        log.info("Payment completed for productId={}", order.getProductId());
    }
}
