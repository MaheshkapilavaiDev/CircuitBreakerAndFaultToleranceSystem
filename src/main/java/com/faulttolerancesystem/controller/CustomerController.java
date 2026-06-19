package com.faulttolerancesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faulttolerancesystem.service.CustomerVerificationService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
    private  CustomerVerificationService service;

    @GetMapping("/verify")
    public String verify() {

        return service.verifyCustomer();
    }
}