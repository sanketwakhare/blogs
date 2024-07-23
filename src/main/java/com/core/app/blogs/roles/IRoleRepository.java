package com.core.app.blogs.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<RoleModel, RoleType> {

    @Query("SELECT r FROM roles r WHERE r.role = ?1")
    Optional<RoleModel> findByRoleName(RoleType role);
}
