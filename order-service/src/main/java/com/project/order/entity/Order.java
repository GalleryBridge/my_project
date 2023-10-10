package com.project.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private Long accountId;
    private String name;
    private String price;
    private String num;
}
