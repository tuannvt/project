package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuctionRepository extends CrudRepository<AuctionEntity, Long> {
  @Query(value = "select * from auction  "
      + "where product_id like %?1% "
      + "ORDER BY startPrice DESC LIMIT 1", nativeQuery = true)
  AuctionEntity findByViewPrice(long id);
  @Query(value = "select * from  auction  "
      + "  where status like ?1)", nativeQuery = true)
  List<AuctionEntity> findByView2( UserStatus status);
}
