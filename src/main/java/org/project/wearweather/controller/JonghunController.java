package org.project.wearweather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JonghunController {
    @GetMapping("/orderlist")//유저의 주문목록
    public String orderlist(){
        return "product/orderlist";
    }

    @GetMapping("/review")//유저의 리뷰쓰기
    public String review(){return "product/review";}

    @GetMapping("/addproduct")//관리자의 상품추가
    public String addproduct(){return "product/addproduct";}

//    @GetMapping("/manageproduct")//관리자의 상품관리
//    public String manageproducts(){return "product/manageproduct";}->관리자로그인시 메인에서 수정

    @GetMapping("/orderproduct")//관리자의 주문관리
    public String orderproducts(){return "product/orderproduct";}

    @GetMapping("/register")
    public String register(){return "user/register";}
}