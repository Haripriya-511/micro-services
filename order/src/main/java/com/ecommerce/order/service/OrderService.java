package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderItemDTO;
import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.models.*;
import com.ecommerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
//    private final UserRepository userRepository;
    public Optional<OrderResponse>
    createOrder(String userId) {
        //validate for cart items
        List<CartItem> cartItems=cartService.getCart(userId);
        if(cartItems.isEmpty()){
            return Optional.empty();
        }
        //validate for user
//        Optional<User> userOptional=userRepository.findById(Long.valueOf(userId));
//        if(userOptional.isEmpty()){
//            return Optional.empty();
//        }
//        User user=userOptional.get();
        //calculate total price
        BigDecimal totalPrice= cartItems.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        //crete order
        Order order=new Order();
        order.setUserId(userId);
        order.setStatus(OrderStatus.CONFIRMED);
        order.setTotalAmount(totalPrice);
        List<OrderItem> orderItems= cartItems.stream()
                .map(item->
                    new OrderItem(null,item.getProductId(),item.getQuantiity(),item.getPrice(),order)
                ).toList();
        order.setItems(orderItems);
        Order savedOrder= orderRepository.save(order);
        //clear the cart
        cartService.clearCart(userId);
        return Optional.of(mapToOrderResponse(savedOrder));
    }
    private OrderResponse mapToOrderResponse(Order savedOrder){
        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getTotalAmount(),
                savedOrder.getStatus(),
                savedOrder.getItems().stream()
                        .map(orderItem -> new OrderItemDTO(
                                orderItem.getId(),
                                orderItem.getProductId(),
                                orderItem.getQuantity(),
                                orderItem.getPrice(),
                                orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity()))
                        ))
                        .toList(),
                savedOrder.getCreatedAt()
        );
    }
}
