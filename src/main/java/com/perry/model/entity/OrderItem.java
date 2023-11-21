package com.perry.model.entity;//package com.perry.model.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.UUID;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID uuid;
//    private Integer quantity;
//    private String name;
//    private Long price;
//
//    @ManyToOne
//    @JoinColumn(name = "uuid")
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "product_uuid")
//    private Product product;
//}
