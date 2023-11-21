package com.perry.model.entity;//package com.perry.model.entity;
//
//import com.perry.model.entity.user.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.UUID;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class CartItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID uuid;
//    private Integer quantity;
//    @ManyToOne
//    @JoinColumn(name = "user_uuid")
//    private User user;
//    @ManyToOne
//    @JoinColumn(name = "product_uuid")
//    private Product product;
//}
