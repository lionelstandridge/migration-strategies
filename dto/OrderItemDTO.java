package com.testcompany.orderservice.dto;

public class OrderItemDTO {
    private Long orderId;
    private Long itemId;
    private boolean moveNamedOrderItems;
    private boolean deleteEmptyNamedOrder;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public boolean getMoveNamedOrderItems() {
        return this.moveNamedOrderItems;
    }

    public void setMoveNamedOrderItems(boolean moveNamedOrderItems) {
        this.moveNamedOrderItems = moveNamedOrderItems;
    }

    public boolean getDeleteEmptyNamedOrder() {
        return this.deleteEmptyNamedOrder;
    }

    public void setDeleteEmptyNamedOrder(boolean deleteEmptyNamedOrder) {
        this.deleteEmptyNamedOrder = deleteEmptyNamedOrder;
    }

}
