package com.faulttolerancesystem.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faulttolerancesystem.service.CreditCheckService;

@RestController
@RequestMapping("/credit")
public class CreditController {

	@Autowired
    private  CreditCheckService service;

    @GetMapping("/score")
    public CompletableFuture<String> score() {

        return service.getCreditScore();
    }
}
