package com.perry.model.entity;//package com.perry.model.entity;
//
//import com.perry.model.entity.user.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Set;
//import java.util.UUID;
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID uuid;
//    private Long total;
//    private String address;
//    private String phone;
//
//    @ManyToOne
//    @JoinColumn(name = "order_status_uuid")
//    private OrderStatus orderStatus;
//
//    @OneToMany(mappedBy = "uuid")
//    private Set<OrderItem> orderItemSet;
//
//    @ManyToOne
//    @JoinColumn(name = "user_uuid")
//    private User user;
//}
