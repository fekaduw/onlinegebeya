package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value="SELECT u FROM User u WHERE u.role.role=?1")
    public List<User> findAllByRole(String role);


    @Query(value="SELECT u FROM User u WHERE u.email=?1")
    public User findByEmail(String uid);
}
