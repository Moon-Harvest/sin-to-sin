package com.harvest.sin_to_sin.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TestController {

    @GetMapping("/test-404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String triggerNotFound() {
        return "error/404";
    }
}
