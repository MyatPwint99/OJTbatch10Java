package com.ojt.blog.persistence.repository;

import com.ojt.blog.persistence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select * from account where username = :username", nativeQuery = true)
    Account findByUsername(String username);
}
