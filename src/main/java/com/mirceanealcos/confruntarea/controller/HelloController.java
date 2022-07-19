package com.mirceanealcos.confruntarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path="/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return "Hello " + name + "!";
    }
}
