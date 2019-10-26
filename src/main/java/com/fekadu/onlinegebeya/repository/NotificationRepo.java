package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Long> {
}
