package com.testcompany.orderservice.adapter;

import com.testcompany.orderservice.dto.OrderDTO;
import com.testcompany.orderservice.dto.OrderItemRequestDTO;

public interface OrderDaoAdapter {
     OrderDTO readCartFortCustomer (Long customerId);
     OrderDTO createNewCartForCustomer(Long customerId);
     OrderDTO addItem(Long orderId, OrderItemRequestDTO request, boolean priceOrder);
     void removeItem(Long orderId, Long itemId, boolean updatePricing);
     void cancelOrder(Long orderId);
}