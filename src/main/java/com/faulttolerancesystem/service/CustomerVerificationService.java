package com.faulttolerancesystem.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CustomerVerificationService {

    @CircuitBreaker(
            name="customerService",
            fallbackMethod="verifyFallback")
    public String verifyCustomer() {

        throw new RuntimeException(
                "KYC Service Down");
    }

    public String verifyFallback(Exception ex) {

        return "Customer Verification Pending";
    }
}