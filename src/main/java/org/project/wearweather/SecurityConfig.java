package org.project.wearweather;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.project.wearweather.entity.Role.ROLE_ADMIN;

@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true) //  @prePost 어노테이션 활성화 (권한이 필요한 API에 @prePost 어노테이션 추가하여 권한 설정할 수 있다. 스프링 시큐리티가 로그인한 회원의 권한을 인식하도록 수정한다.)
@Configuration // 서버가 기동될 때 설정해주겠다.
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.(스프링 security 지원을 가능하게 함)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    // 해당 메서드의 리턴되는 오브젝트를 IoC 로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }


    // BCryptPasswordEncoder 는 Spring Security 에서 제공하는 비밀번호 암호화 객체이다.
    // Service 에서 비밀번호를 암호화할 수 있도록 Bean 으로 등록한다.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // js, css, image 설정은 보안 설정의 영향 밖에 있도록 만들어주는 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").access("hasRole("+ ROLE_ADMIN +")")
                .antMatchers("/","/fonts/**","/images/**","/vendor/**", "/user/availability/**", "/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login") // 로그인 View 제공 (GET /user/login)
                .loginProcessingUrl("/loginPost") // /login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해준다. (controller 에 /login 을 안넣어줘도 된다. 시큐리티가 대신 해줌) // 로그인 처리 (POST /user/loginPost)
                .usernameParameter("userId")
                .passwordParameter("userPwd")
                .defaultSuccessUrl("/") // 로그인 처리 후 성공 시 URL
                .failureUrl("/user/login?error") // 로그인 처리 후 실패 시 URL
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/user/logout") // 로그아웃 요청 처리 URL
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        String password = passwordEncoder().encode("1111");

//        auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMIN","USER");
    }

}