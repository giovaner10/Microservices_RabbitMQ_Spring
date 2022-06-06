package com.auth.repository;

import com.auth.entity.Use;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Use, Long> {

    @Query("SELECT u FROM Use u WHERE u.userName =:userName")
    Use findByUserName(@Param("userName") String userName);

}
