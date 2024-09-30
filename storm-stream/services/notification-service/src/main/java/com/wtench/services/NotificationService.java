package com.wtench.services;

import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.domain.Notification;
import com.wtench.repo.NotificationRepository;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Getter
@Service
@MappedSuperclass
public class NotificationService implements DomainEntityService<Notification, NotificationRepository> {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification save(Notification entity) {
        return getRepository().save(entity);
    }

    @Override
    public Page<Notification> list(Pageable pageable) {
        return getRepository().findAll(pageable);
    }
}
