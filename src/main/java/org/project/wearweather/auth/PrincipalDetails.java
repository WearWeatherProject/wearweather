package org.project.wearweather.auth;



import lombok.Data;
import org.project.wearweather.entity.Role;
import org.project.wearweather.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 이때 로그인 진행이 완료가 되면 시큐리티가 가지고 있는 시큐리티 session(Security session)을 만들어준다.
// 즉, 세션 공간은 똑같은데 같은 세션 공간인데 시큐리티가 자신만의 세션 공간을 가진다.
// 키값으로 구분을 하는데 그 키값을 Security ContextHolder 라고 한다.
// 이 키값에 세션 정보를 저장하는 방식으로 이루어진다.
// 이 키값에 들어갈 수 있는 세션 즉, 세션에 저장할 수 있는 어떤 정보는
// 다시 말하면 시큐리티가 가지고 있는 세션에 들어갈 수 있는 오브젝트는 정해져있다.
// 바로 Authentication 타입의 객체이다.
// 이 Authentication 안에는 유저 정보가 있어야 하는데 이 유저 정보로 들어오는 타입은
// UserDetails 타입의 객체만 들어갈 수 있다.


// 시큐리티가 가지고 있는 시큐리티 세션 영역이 있는데
// 여기에 세션 정보를 저장해주는데 여기에 들어갈 수 있는 객체가
// Authentication 타입의 객체만 들어갈 수 있다.
// 이 Authentication 객체 안에는 유저 정보가 들어있는데
// 이 유저 정보를 저장할 때는 UserDetails 타입의 객체만 저장될 수 있다.
//* Security session => Authentication => UserDetails(PrincipalDetails)
// 나중에 세션을 사용하기 위해 Security session 에서 get 방식으로 세션을 꺼내 사용하는데
// 세션을 꺼내면 Authentication 객체가 나오게 된다.
// 또 Authentication 에서 UserDetails 객체를 꺼내면 유저 object 에 접근할 수 있게 된다.


// 얘는 강제로 띄울거라 @Service 안해줘도 됨,,
@Data
public class PrincipalDetails implements UserDetails {

    private User user; // 컴포지션

    public PrincipalDetails(User user) {// user 를 받아서 생성자에 넣어준다.
        this.user = user;
    }


    // 해당 유저의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(() -> {return user.getRole().toString();});

        return collect;
    }

    @Override
    public String getPassword() {
        return user.getUserPwd();
    }

    @Override
    public String getUsername() {
        return user.getUserID();
    }


    /* 계정 만료 여부
     * true : 만료 안됨
     * false : 만료
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    /* 계정 잠김 여부
     * true : 잠기지 않음
     * false : 잠김
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    /* 비밀번호 만료 여부
     * true : 만료 안됨
     * false : 만료
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* 사용자 활성화 여부
     * true : 만료 안됨
     * false : 만료
     */
    @Override
    public boolean isEnabled() {

        // 만일 우리 사이트는 1년동안 회원이 로그인을 안하면 휴먼 계정으로 하기로 한다면
        // 현재시간 - 로그인시간 => 1년 초과 시 return false 해주면 된다.

        return true;
    }
}
