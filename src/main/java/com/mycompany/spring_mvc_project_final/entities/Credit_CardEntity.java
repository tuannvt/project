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
@Table(name = "credit_card")

public class Credit_CardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "credit_card_id")
  private long credit_card_id;
  @ManyToOne
  @JoinColumn(name = "account_id")
  private AccountEntity account;
  @Column(name = "cardNumber")
  private String cardNumber;
  @Column(name = "expiryDate")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate expiryDate;
  @Column(name = "CVCcode")
  private String CVCcode;
  @Column(name = "cardHolder")
  private String cardHolder;
  @Column(name = "balance")
  private double balance;

  public Credit_CardEntity() {
  }

  public long getCredit_card_id() {
    return credit_card_id;
  }

  public void setCredit_card_id(long credit_card_id) {
    this.credit_card_id = credit_card_id;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
  }

  public String getCVCcode() {
    return CVCcode;
  }

  public void setCVCcode(String CVCcode) {
    this.CVCcode = CVCcode;
  }

  public String getCardHolder() {
    return cardHolder;
  }

  public void setCardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
