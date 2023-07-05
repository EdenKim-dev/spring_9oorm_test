package com.example.kakao.orders;

import lombok.*;

import javax.persistence.*;

@Table(name="orders")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int memberId;

    @Builder
    public Order (int orderId, int memberId) {
        this.orderId = orderId;
        this.memberId = memberId;
    }
}
