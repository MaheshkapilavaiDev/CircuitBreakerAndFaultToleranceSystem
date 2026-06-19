package com.faulttolerancesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faulttolerancesystem.entity.FailureAudit;
import com.faulttolerancesystem.repository.FailureAuditRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class CreditCheckService {

    @Autowired
    private ExternalApiService apiService;
    
    @Autowired
    private FailureAuditRepository repository;

    @CircuitBreaker(
            name = "creditService",
            fallbackMethod = "creditFallback")
    @Retry(name = "creditService")
    @TimeLimiter(name = "creditService")
    public CompletableFuture<String> getCreditScore() {

        return CompletableFuture.supplyAsync(
                () -> apiService.callCreditApi());
    }

    public String creditFallback(
            Exception ex) {

    FailureAudit audit = new FailureAudit();

    audit.setServiceName("Credit Service");
    audit.setErrorMessage(ex.getMessage());
    audit.setFailureTime(LocalDateTime.now());

    repository.save(audit);

    return "Fallback Response Returned";
}
}
