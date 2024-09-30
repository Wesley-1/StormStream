package com.wtench.controller;

import com.wtench.StormCloud.controllers.DomainEntityController;
import com.wtench.domain.Notification;
import com.wtench.repo.NotificationRepository;
import com.wtench.response.NotificationDTO;
import com.wtench.services.NotificationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@RestController
@RequestMapping("api/notifications")
public class NotificationController implements DomainEntityController<NotificationDTO, Notification, NotificationRepository> {

    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path="/allNotifications")
    public Page<NotificationDTO> list(Pageable pageable) {
        return getService().getRepository().findAll(pageable).map(this::mapEntity);
    }

    @PostMapping(value = "/addNotification")
    public Notification post(Notification message) {
        return message;
    }

    @Override
    public NotificationDTO mapEntity(Notification entity) {
        return NotificationDTO.builder()
                .service(entity.getService())
                .timestamp(entity.getTimestamp())
                .message(entity.getMessage())
                .id(entity.getId())
                .build();
    }

}
