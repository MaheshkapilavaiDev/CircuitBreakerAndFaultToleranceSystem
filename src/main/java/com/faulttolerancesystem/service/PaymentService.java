package com.faulttolerancesystem.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PaymentService {

    @CircuitBreaker(
            name = "paymentService",
            fallbackMethod = "paymentFallback")
    public String processPayment() {

        throw new RuntimeException(
                "Payment Gateway Down");
    }

    public String paymentFallback(Exception ex) {

        return "Payment Queued Successfully";
    }
}
