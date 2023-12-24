package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bid")

public class BidEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bid_id")
  private long bid_id;
  @ManyToOne
  @JoinColumn(name = "account_id")
  private AccountEntity account;
  @ManyToOne
  @JoinColumn(name = "auction_id")
  private AuctionEntity auction;
  @Column(name = "timeStamp")
  private String timeStamp;
  @Column(name = "amount")
  private double amount;
  @Column(name = "status",nullable = false)
  @Enumerated(EnumType.STRING)
  private UserStatus status;

  public BidEntity() {
  }

  public UserStatus getStatus() {
    return status;
  }

  public void setStatus(UserStatus status) {
    this.status = status;
  }

  public long getBid_id() {
    return bid_id;
  }

  public void setBid_id(long bid_id) {
    this.bid_id = bid_id;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public AuctionEntity getAuction() {
    return auction;
  }

  public void setAuction(AuctionEntity auction) {
    this.auction = auction;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
