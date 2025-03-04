package com.harvest.sin_to_sin.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.harvest.sin_to_sin.model.ApplicationUserDTO;
import com.harvest.sin_to_sin.service.ApplicationUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class CustomerManagementController {

    private final ApplicationUserService applicationUserService;

    @GetMapping("/{customer_id}")
    public String getCustomer(@PathVariable("customer_id") Long customerId, Model model) {
        ApplicationUserDTO customer = applicationUserService.getCustomerDTOById(customerId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        model.addAttribute("customer", customer);
        return "customer";
    }

}
