package com.project.order.service;

import com.project.order.entity.Order;

public interface IOrderService {
    public Order queryByID(Long id);
}
