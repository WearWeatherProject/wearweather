package org.project.wearweather.controller;

import org.hibernate.service.spi.InjectService;
import org.project.wearweather.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class HyunjiController {

    // 스프링시큐리티가 해당 주소를 낚아챔 - SecurityConfig 파일 생성 후 작동안함.
    // 로그인 폼 페이지
    @GetMapping("/login")
    public String login() {return "/user/login";}

    // 로그인 버튼 누르면 실행되는 아이
    // 로그인 성공시 -> "redirect:/"
    //       실패시 -> "redirect:/user/login?error"
    @PostMapping("/loginPost")
    public void loginPOST(UserDTO dto) {}


    // 로그아웃
    /*
    "GET /user/logout" 로 API 설계 했는데, "POST /user/logout" 으로 처리 필요
    CSRF protection 이 기본적으로 enable 되어 있기 때문
    CSRF protection 을 disable 하면 GET /user/logout 으로도 사용 가능
    */
    @GetMapping("/logout")
    public String logout() {return "redirect:/user/login";}


    // 장바구니
    @GetMapping("/cart")
    public String cart() {return "/product/shopping-cart";}


    // 마이페이지
    @GetMapping("/mypage")
    public String mypage() {return "/user/mypage";}


    // 회원정보 수정
    @GetMapping("/modify")
    public String modify() {return "/user/modify";}


    // 회원탈퇴
    @GetMapping("/quituser")
    public String quituser() {return "/user/quituser";}



}