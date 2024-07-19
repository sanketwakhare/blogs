package com.core.app.blogs.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<RoleModel, RoleType> {
}
