package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuctionRepository extends CrudRepository<AuctionEntity, Long> {
  @Query(value = "SELECT  p.product_id, p.product_img, p.product_name, a.endTime, a.startPrice  " +
      "FROM auction a  join product p " +
      "on a.product_id = p.product_id "
      , nativeQuery = true)
  List<AuctionEntity> findByView();
}
