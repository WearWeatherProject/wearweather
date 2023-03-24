package org.project.wearweather.repository;

import org.project.wearweather.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserID(String userID);

}
