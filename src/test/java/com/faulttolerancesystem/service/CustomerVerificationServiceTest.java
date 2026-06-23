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
class CustomerVerificationServiceTest {

    @InjectMocks
    private CustomerVerificationService service;

    @Mock
    private FailureAuditRepository repository;

    @Test
    void testVerifyFallback() {

        String result = service.verifyFallback(
                new RuntimeException("KYC Service Down"));

        assertEquals(
                "Customer Verification Pending",
                result);
    }
}
