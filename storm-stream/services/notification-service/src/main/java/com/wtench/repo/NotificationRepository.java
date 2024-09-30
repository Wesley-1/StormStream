package com.wtench.repo;

import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.domain.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends StormCrudRepository<Notification, String> {
}
