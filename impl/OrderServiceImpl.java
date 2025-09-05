package com.testcompany.orderservice.impl;

import com.testcompany.orderservice.api.OrderService;
import com.testcompany.orderservice.adapter.OrderDaoAdapter;
import com.testcompany.orderservice.adapter.OrderItemAdapter;
import com.testcompany.orderservice.dto.OrderDTO;
import com.testcompany.orderservice.dto.OrderItemDTO;
import com.testcompany.orderservice.dto.OrderItemRequestDTO;
import com.testcompany.orderservice.exception.AddToCartException;
import com.testcompany.orderservice.exception.RemoveFromCartException;

public class OrderServiceImpl implements OrderService {

    private final OrderDaoAdapter orderDao;
    private final OrderItemAdapter orderItemAdapter;
    
    public OrderServiceImpl(OrderDaoAdapter orderDao, OrderItemAdapter orderItemAdapter) {
        this.orderDao = orderDao;
        this.orderItemAdapter = orderItemAdapter;
    }

    @Override
    public OrderDTO addItemFromNamedOrder(Long customerId, OrderItemDTO itemDTO, boolean priceOrder)
            throws AddToCartException, RemoveFromCartException {

        OrderDTO cartOrder = this.orderDao.readCartFortCustomer(customerId);

        if (cartOrder == null) {
            cartOrder = this.orderDao.createNewCartForCustomer(customerId);
        }

        OrderItemRequestDTO request = this.orderItemAdapter.buildRequest(itemDTO);
        cartOrder = this.orderDao.addItem(cartOrder.getId(), request, priceOrder);

        if (itemDTO.isMovedNamedOrderItems()) {
            this.orderDao.removeItem(itemDTO.getOrderId(), itemDTO.getItemId(), false);
        }

        if(itemDTO.shouldDeleteEmptyNamedOrder()) {
            this.orderDao.cancelOrder(itemDTO.getOrderId());
        }

        return cartOrder;
    }
}
