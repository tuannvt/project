package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.BidEntity;
import org.springframework.data.repository.CrudRepository;

public interface BidRepository extends CrudRepository<BidEntity, Long> {
  BidEntity findByAccount_id(long account_id);
}
