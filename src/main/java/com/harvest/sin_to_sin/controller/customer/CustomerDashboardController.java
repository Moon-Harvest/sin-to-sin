package com.harvest.sin_to_sin.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerDashboardController {

    @GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "customer_dashboard";
    }

}
