package com.boa.circuitbreakerdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.circuitbreakerdemo.services.CBService;


@RestController
public class CBController {

    @Autowired
    private CBService cbService;

    @GetMapping("/")
    public String getValues() {
        return cbService.fetchData();
    }
}
