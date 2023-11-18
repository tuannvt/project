package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.Status;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "auction")

public class AuctionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "auction_id")
  private long auction_id;
  @ManyToOne
  @JoinColumn(name = "account_id")
  private AccountEntity account;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductEntity product;
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private Status status;
  @Column(name = "endTime")
  private String endTime;
  @Column(name = "startPrice")
  private double startPrice;
  @Column(name = "reservePrice")
  private double reservePrice;
  @Column(name = "commission")
  private double commission;

  public AuctionEntity() {
  }

  public long getAuction_id() {
    return auction_id;
  }

  public void setAuction_id(long auction_id) {
    this.auction_id = auction_id;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public ProductEntity getProduct() {
    return product;
  }

  public void setProduct(ProductEntity product) {
    this.product = product;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public double getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(double startPrice) {
    this.startPrice = startPrice;
  }

  public double getReservePrice() {
    return reservePrice;
  }

  public void setReservePrice(double reservePrice) {
    this.reservePrice = reservePrice;
  }

  public double getCommission() {
    return commission;
  }

  public void setCommission(double commission) {
    this.commission = commission;
  }
}
