package com.core.app.blogs.users;

import com.core.app.blogs.common.BaseModel;
import com.core.app.blogs.common.constants.GenericConst;
import com.core.app.blogs.roles.RoleModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@Data
@NoArgsConstructor
public class UserModel extends BaseModel {

    @NonNull
    @Email(regexp = GenericConst.EMAIL_VALIDATION_PATTERN, message = "Invalid email")
    @Column(name = "email", nullable = false, unique = true, length = 30)
    private String email;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @Column
    private String name;

    @Column
    private String bio;

    @ManyToMany
//    @LazyCollection(value = LazyCollectionOption.FALSE)
    @Lazy(value = false)
    private Set<RoleModel> roles;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
}
