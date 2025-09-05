package com.testcompany.orderservice.api;

import com.testcompany.orderservice.dto.OrderDTO;
import com.testcompany.orderservice.dto.OrderItemRequestDTO;
import com.testcompany.orderservice.exception.AddToCartException;
import com.testcompany.orderservice.exception.RemoveFromCartException;

public interface OrderService {
    OrderDTO addItemFromNameOrder(Long customerId, OrderItemDTO item, boolean priceOrder)
        throws AddToCartException, RemoveFromCartException;
    
}
