package com.pc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Welcome {

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name){
        return "Welcome "+ name + " !!!";
    }

    @GetMapping("/welcome")
    public String welcomeWithParam(@RequestParam String name){
        return "Welcome "+ name + " !!!";
    }
}
