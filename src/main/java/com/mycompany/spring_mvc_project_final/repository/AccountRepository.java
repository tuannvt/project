/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    AccountEntity findByEmailLikeAndStatusLike(String email,
            UserStatus status);
    @Query(value = "SELECT  auction_role.role_id  FROM account " +
        "left join auction_role on account.id=auction_role.user_id " +
        "where email like %?1%  "
        , nativeQuery = true)
    AccountEntity findByAcc(String email);
    AccountEntity findByEmail(String email);
}
