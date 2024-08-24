package com.kh.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double totalPrice;
  // user id

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  // order id

  @OneToMany(mappedBy = "order")
  private List<OrderDetail> orderDetail;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<OrderDetail> getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(List<OrderDetail> orderDetail) {
    this.orderDetail = orderDetail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public String toString() {
    return "Orders [id=" + id + ", totalPrice=" + totalPrice + "]";
  }

}
