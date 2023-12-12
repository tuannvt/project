package com.mycompany.spring_mvc_project_final.repository;


import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
  @Query(value = " select  *  from  product "
      + "    where product_id in ( "
      + "            select  distinct product_id  "
      + "            from auction  "
      + "            left join account  "
      + "                    on auction.account_id = account.id  "
      + "            left join account_role  "
      + "                    on account.id=account_role.user_id  )"
      , nativeQuery = true)
  List<ProductEntity> findByView1(String role_id);
}
