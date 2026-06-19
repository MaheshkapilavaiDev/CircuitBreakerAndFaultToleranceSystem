package com.faulttolerancesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faulttolerancesystem.entity.FailureAudit;
import com.faulttolerancesystem.repository.FailureAuditRepository;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@RestController
@RequestMapping("/circuit")
public class CircuitBreakerController {

	@Autowired
    private  CircuitBreakerRegistry registry;
	
	@Autowired
	private FailureAuditRepository repository;

    @GetMapping("/status/{name}")
    public String status(
            @PathVariable String name) {

        return registry
                .circuitBreaker(name)
                .getState()
                .name();
    }
    
    @PostMapping("/reset/{name}")
    public String reset(
            @PathVariable String name) {

        registry.circuitBreaker(name).reset();

        return "Circuit Reset Successfully";
    }
    @GetMapping("/failures")
    public List<FailureAudit> failures() {

        return repository.findAll();
    }
}
