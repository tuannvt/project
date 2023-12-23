package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuctionRepository extends CrudRepository<AuctionEntity, Long> {
  @Query(value = "select * from auction  "
      + "where product_id like %?1% "
      + "ORDER BY startPrice DESC LIMIT 1", nativeQuery = true)
  AuctionEntity findByViewPrice(long id);
  @Query(value = "SELECT * FROM auction "
      + " where endTime is not NULL AND status = 'ACTIVE'", nativeQuery = true)
  List<AuctionEntity> findByViewEndTime();

  @Modifying
  @Transactional
  @Query(value = "UPDATE auction set status = 'UNACTIVE' WHERE auction_id = ?1", nativeQuery = true)
  void updateAuctionById(long id);
}
