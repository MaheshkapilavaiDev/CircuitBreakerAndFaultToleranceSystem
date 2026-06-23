package com.faulttolerancesystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.faulttolerancesystem.entity.FailureAudit;
import com.faulttolerancesystem.repository.FailureAuditRepository;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private FailureAuditRepository repository;

    @Test
    void testPaymentFallback() {

        String result = paymentService
                .paymentFallback(
                        new RuntimeException("Payment Gateway Down"));

        assertEquals(
                "Payment Service Temporarily Unavailable",
                result);

        verify(repository, times(1))
                .save(any(FailureAudit.class));
    }
}
