package org.project.wearweather.repository;

import org.project.wearweather.dto.UserDTO;
import org.project.wearweather.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// CRUD 함수를 JpaRepository 가 들고 있다.
// @Repository 라는 어노테이션이 없어도 JpaRepository 를 상속했기 때문에 IoC 가 된다.
// 그래서 자동으로 UserRepository 가 빈으로 등록이 된다..?
public interface UserRepository extends JpaRepository<User, Long> {

    /* findBy규칙 -> Username문법 */

    // select * from user where username = ?(<-파라미터) 이게 호출이 된다.
    public User findByUserID(String username); //Jpa Query methods

}
