package com.mycompany.spring_mvc_project_final.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
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
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate timeStamp;
  @Column(name = "amount")
  private double amount;

  public BidEntity() {
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

  public LocalDate getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(LocalDate timeStamp) {
    this.timeStamp = timeStamp;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
