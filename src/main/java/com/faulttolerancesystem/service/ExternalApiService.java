package com.faulttolerancesystem.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

    public String callCreditApi() {

       /* Random random = new Random();

        if(random.nextBoolean()) {
            throw new RuntimeException("Credit API Down");
        }

        return "Credit Score : 780";
    }*/
    	
    	 throw new RuntimeException("Credit API Down");
    }
}
