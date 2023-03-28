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
    // 로그인 폼
    @GetMapping("/login")
    public String login() {return "/user/login";}

    @PostMapping("/loginPost")
    public void loginPOST(UserDTO dto) {}


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