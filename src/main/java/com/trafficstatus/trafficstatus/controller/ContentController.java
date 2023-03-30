package com.trafficstatus.trafficstatus.controller;

import com.trafficstatus.trafficstatus.DTO.HelloWsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ContentController {

    private static final String contentTemplate = "Hello, tarane! %s" ;
    private final AtomicLong contentCounter = new AtomicLong();

    @GetMapping("/salut")
    public HelloWsDTO helloCall(@RequestParam(value = "name", defaultValue = "Merge Treaba?") String name){
        return new HelloWsDTO(String.format(contentTemplate, name), (contentCounter.incrementAndGet()));
    }
}
