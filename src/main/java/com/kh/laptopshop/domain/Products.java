package com.kh.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Products {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty(message = "Ten San Pham Khong Duoc De Trong")
  private String name;

  @NotNull
  @DecimalMin(value = "0", inclusive = false, message = "Price Phai Lon Hon 0")
  private double price;

  private String image;

  @NotNull
  @NotEmpty(message = "detailDesc khong duoc de trong")
  @Column(columnDefinition = "MEDIUMTEXT")
  private String detailDesc;

  @NotNull
  @NotEmpty(message = "shortDesc khong duoc de trong")
  private String shortDesc;

  @NotNull
  @Min(value = 1, message = "So luong can nhap vao lon hon hoac bang 1")
  // fix convert String to Long
  private long quantity;

  private long sold;
  private String factory;
  private String target;

  // OrderDetail_id
  @OneToMany(mappedBy = "product")
  private List<OrderDetail> orderDetail;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDetailDesc() {
    return detailDesc;
  }

  public void setDetailDesc(String detailDesc) {
    this.detailDesc = detailDesc;
  }

  public String getShortDesc() {
    return shortDesc;
  }

  public void setShortDesc(String shortDesc) {
    this.shortDesc = shortDesc;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public long getSold() {
    return sold;
  }

  public void setSold(long sold) {
    this.sold = sold;
  }

  public String getFactory() {
    return factory;
  }

  public void setFactory(String factory) {
    this.factory = factory;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  @Override
  public String toString() {
    return "Products [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", detailDesc="
        + detailDesc + ", shortDesc=" + shortDesc + ", quantity=" + quantity + ", sold=" + sold + ", factory=" + factory
        + ", target=" + target + "]";
  }

  public List<OrderDetail> getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(List<OrderDetail> orderDetail) {
    this.orderDetail = orderDetail;
  }

}
