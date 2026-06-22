package com.faulttolerancesystem.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faulttolerancesystem.entity.FailureAudit;
import com.faulttolerancesystem.repository.FailureAuditRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PaymentService {
	
	@Autowired
	private FailureAuditRepository repository;

    @CircuitBreaker(
            name = "paymentService",
            fallbackMethod = "paymentFallback")
    public String processPayment() {

        throw new RuntimeException(
                "Payment Gateway Down");
    }

    public String paymentFallback(Exception ex) {
    	
    	FailureAudit audit = new FailureAudit();
        audit.setServiceName("Payment Service");
        audit.setErrorMessage(ex.getMessage());
        audit.setFailureTime(LocalDateTime.now());

        repository.save(audit);

        return "Payment Service Temporarily Unavailable";
    }
}
