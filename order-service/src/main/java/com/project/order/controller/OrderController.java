package com.project.order.controller;

import com.project.order.entity.Order;
import com.project.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Resource
    private IOrderService orderService;

    @GetMapping("/{id}")
    public Order queryByID(@PathVariable("id") Long id){
        return orderService.queryByID(id);
    }
}
