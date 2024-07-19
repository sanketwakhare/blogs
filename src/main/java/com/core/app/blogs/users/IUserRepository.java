package com.core.app.blogs.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
}
