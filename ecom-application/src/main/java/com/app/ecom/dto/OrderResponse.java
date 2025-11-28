package com.app.ecom.dto;

import com.app.ecom.entity.OrderStatus;
import com.app.ecom.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private List<OrderItemDTO> items;
    private LocalDateTime createdAt;


}
