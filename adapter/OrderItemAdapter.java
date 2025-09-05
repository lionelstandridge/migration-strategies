package com.testcompany.orderservice.adapter;

import com.testcompany.orderservice.dto.OrderDTO;
import com.testcompany.orderservice.dto.OrderItemRequestDTO;


public interface OrderItemAdapter {
    OrderItemRequestDTO buildRequest(OrderItemDTO itemDTO);
}
