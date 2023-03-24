package org.project.wearweather;

import org.junit.jupiter.api.Test;
import org.project.wearweather.entity.Role;
import org.project.wearweather.entity.User;
import org.project.wearweather.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class WearweatherApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void joinTests() throws Exception{

		User user = new User();
		user.setUserID("wn1331");
		user.setUserPwd("1234");
		user.setRole(Role.ROLE_ADMIN);
		user.setUserEmail("wnwhdgns12@naver.com");
		user.setUserPhone("01068898243");
		user.setUserName("주종훈");
		user.setMileage(0);
		LocalDateTime nowDate = LocalDateTime.now();
		user.setUserRegDate(nowDate);
		user.setUserAddress("경기도 성남시 분당구 삼평동 801-1101");
		userRepository.save(user);
	}

}
