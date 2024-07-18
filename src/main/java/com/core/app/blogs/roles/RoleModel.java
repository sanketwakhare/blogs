package com.core.app.blogs.roles;

import com.core.app.blogs.common.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "roles")
@NoArgsConstructor
public class RoleModel extends BaseModel {

    @NonNull
    @Column(name = "role", nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private RoleType role;
}
