package org.project.wearweather.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.project.wearweather.dto.RegisterDTO;
import org.project.wearweather.entity.Role;
import org.project.wearweather.entity.User;
import org.project.wearweather.repository.UserRepository;
import org.project.wearweather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class JonghunController {

    private final UserService userService;

    @GetMapping("/orderlist")//유저의 주문목록
    public String orderlist() {
        return "product/orderlist";
    }

    @GetMapping("/review")//유저의 리뷰쓰기
    public String review() {
        return "product/review";
    }

    @GetMapping("/addproduct")//관리자의 상품추가
    public String addproduct() {
        return "product/addproduct";
    }

//    @GetMapping("/manageproduct")//관리자의 상품관리
//    public String manageproducts(){return "product/manageproduct";}->관리자로그인시 메인에서 수정

    @GetMapping("/orderproduct")//관리자의 주문관리
    public String orderproducts() {
        return "product/orderproduct";
    }

    @GetMapping("/register")
    public String register() {
//        System.out.println("get방식호출 회원가입화면");
        return "user/register";
    }
    @PostMapping("/register")
    public String registerPOST(RegisterDTO dto) throws Exception {
        //System.out.println("service 실행 중..");
        userService.registerUser(dto);
        //System.out.println("회원가입 버튼클릭후 받아온 dto ->>>>"+dto.toString());
        return "index";
    }
}