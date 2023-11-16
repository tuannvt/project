package com.mycompany.spring_mvc_project_final.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credit")

public class CreditEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "credit_id")
  private long credit_id;
  @ManyToOne
  @JoinColumn(name = "account_id")
  private AccountEntity account;
  @Column(name = "balance")
  private double balance;
  public CreditEntity() {
  }

  public long getCredit_id() {
    return credit_id;
  }

  public void setCredit_id(long credit_id) {
    this.credit_id = credit_id;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
