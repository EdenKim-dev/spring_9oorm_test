package com.example.kakao.orders;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderListId;
    private int optionId;
    private int quantity;
    private int price;

    private int orderId;

    @Builder
    public OrderList(int orderListId, int optionId, int quantity, int price, int orderId) {
        this.orderListId = orderListId;
        this.optionId = optionId;
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
    }
}
