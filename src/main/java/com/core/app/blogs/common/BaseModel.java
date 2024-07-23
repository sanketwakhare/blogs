package com.core.app.blogs.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Setter
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Setter
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}
