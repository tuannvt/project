package com.mycompany.spring_mvc_project_final.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private long product_id;
  @Column(name = "product_name")
  private String product_name;
  @Column(name = "product_img")
  private String product_img;
  @Column(name = "description")
  private String description;
  @OneToMany(mappedBy = "product")
  private Set<AuctionEntity> auctions;

  public ProductEntity() {
  }

  public long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(long product_id) {
    this.product_id = product_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getProduct_img() {
    return product_img;
  }

  public void setProduct_img(String product_img) {
    this.product_img = product_img;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<AuctionEntity> getAuctions() {
    return auctions;
  }

  public void setAuctions(
      Set<AuctionEntity> auctions) {
    this.auctions = auctions;
  }
}
