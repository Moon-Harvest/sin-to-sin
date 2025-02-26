package com.harvest.sin_to_sin.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harvest.sin_to_sin.model.CustomerOrder;
import com.harvest.sin_to_sin.service.OrderService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/admin/orders/{order_id}")
    public String getOrder(@PathVariable("order_id") Model model) {
        return "unimplemented";
    }

    @GetMapping("/orders")
    public String getOrders(@RequestParam(name = "filter", required = false, defaultValue = "none") String filter,
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {
        List<CustomerOrder> orders;

        switch (filter.toLowerCase()) {
            case "day":
                orders = orderService.getOrdersByDay(date != null ? date : LocalDate.now())
                        .orElse(Collections.emptyList());
                break;
            case "week":
                orders = orderService.getOrdersByWeek(LocalDate.now()).orElse(Collections.emptyList());
                break;
            case "month":
                orders = orderService.getOrdersByMonth(LocalDate.now()).orElse(Collections.emptyList());
                break;
            case "year":
                orders = orderService.getOrdersByYear(LocalDate.now()).orElse(Collections.emptyList());
                break;
            default:
                orders = Collections.emptyList();
        }

        model.addAttribute("orders", orders);
        model.addAttribute("filter", filter);
        model.addAttribute("date", date);

        return "orders";
    }

}
