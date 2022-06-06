package com.auth.repository;

import com.auth.entity.Permissio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface PermissionRepository extends JpaRepository<Permissio, Long> {

    @Query("SELECT p FROM Permissio p WHERE p.description =:description")
    Permissio findByDescription(@Param("description") String description);
}
