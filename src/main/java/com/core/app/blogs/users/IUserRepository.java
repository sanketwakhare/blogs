package com.core.app.blogs.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<UserModel, String> {
}
