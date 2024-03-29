//package org.example.domain;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//@Table(name = "ORDERS")
//public class Order {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "ORDER_ID")
//    private Long id;
//
//    @Column(name = "MEMBER_ID")
//    private Long memberId;
//
//    // private Member member로 찾아야겠지?
//    private LocalDateTime OrderDate; // DB들이 원하는것 : ORDER_DATE or order_date
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus status;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }
//
//    public LocalDateTime getOrderDate() {
//        return OrderDate;
//    }
//
//    public void setOrderDate(LocalDateTime orderDate) {
//        OrderDate = orderDate;
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OrderStatus status) {
//        this.status = status;
//    }
//}