package com.mycompany.spring_mvc_project_final.repository;


import com.mycompany.spring_mvc_project_final.entities.BidEntity;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BidRepository extends CrudRepository<BidEntity, Long> {
  @Query(value = "SELECT * FROM bid "
      + " where account_id = ?1 AND status = 'ACTIVE'", nativeQuery = true)
  List<BidEntity> findByAccount_id(long account_id);
  @Query(value = "SELECT * FROM bid "
      + " where account_id = ?1 AND status = 'UNACTIVE'", nativeQuery = true)
  List<BidEntity> findByAccount1(long account_id);
}
