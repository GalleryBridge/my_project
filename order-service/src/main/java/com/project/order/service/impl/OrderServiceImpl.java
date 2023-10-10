package com.project.order.service.impl;

import com.project.order.entity.Order;
import com.project.order.mapper.OrderMapper;
import com.project.order.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order queryByID(Long id) {
        return orderMapper.findById(id);
    }
}
