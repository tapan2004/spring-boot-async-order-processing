package com.example.async.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {
    private int productId;
    private String productName;
    private String productType;
    private int productQty;
    private double price;
    private String trackingId;
}