package com.example.kakao.products;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String description;
    private String image;
    private int price;

    Product(int id, String name, String description, String image, int price) {
        this.productId =id;
        this.productName=name;
        this.description =description;
        this.image = image;
        this.price=price;
    }

    public static class Builder {
        private int productId;
        private String productName;
        private String description;
        private String image;
        private int price;

        public Builder(int id, String name, String description, String image, int price) {
            this.productId=id;
            this.productName=name;
            this.description=description;
            this.image=image;
            this.price=price;
        }

        public Product build() {
            return new Product(productId,productName,description,image, price);
        }
    }
}
