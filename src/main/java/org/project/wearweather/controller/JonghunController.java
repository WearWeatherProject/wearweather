package org.project.wearweather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JonghunController {
    @GetMapping("/orderlist")
    public String orderlist(){
        return "product/orderlist";
    }

    @GetMapping("/review")
    public String review(){return "product/review";}
}