package com.faulttolerancesystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.faulttolerancesystem.service.CreditCheckService;
import com.faulttolerancesystem.service.ExternalApiService;

@ExtendWith(MockitoExtension.class)
class CreditServiceTest {

    @InjectMocks
    private CreditCheckService service;

    @Mock
    private ExternalApiService apiService;

    @Test
    void testCreditScore() {

        when(apiService.callCreditApi())
                .thenReturn("780");

        String score =
                service.getCreditScore().join();

        assertEquals("780", score);
    }
    
    @Test
    void testCreditFallback() {

        String result = service
                .creditFallback(new RuntimeException("API Down"))
                .join();

        assertEquals(
                "Credit Service Temporarily Unavailable",
                result);
    }
}