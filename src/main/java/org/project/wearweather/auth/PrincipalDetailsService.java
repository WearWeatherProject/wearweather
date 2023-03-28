package org.project.wearweather.auth;

import lombok.RequiredArgsConstructor;
import org.project.wearweather.entity.User;
import org.project.wearweather.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 시큐리티 설정에서 loginProcessingUrl("/login"); 으로 걸어놨기 때문에
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는
// loadUserByUsername 함수가 실행된다.
// @Service 해주면 PrincipalDetailsService 얘는 IoC 에 등록이 된다.
/*@Transactional
@RequiredArgsConstructor
@Component*/
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // 시큐리티 session = Authentication = UserDetails
    // 아래의 UserDetails 가 리턴 되면 Authentication 내부에 들어가게 된다.
    // 그러고 이 Authentication 는 시큐리티 session 내부에 들어가게 된다.
    // => 시큐리티 session(내부 Authentication(내부 UserDetails))
    // 이걸 loadUserByUsername 가 알아서 해준다..
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUserID(username);

        if(userEntity != null) {
            System.out.println("*** 님,,,, 들어오셨나요,,?");
            return new PrincipalDetails(userEntity);// Authentication 내부에 들어감
        }

        return null;
    }
}
