package com.wk.platform.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("test")
    public String helloWorld(){
        return "helloworld";
    }
}
