package org.project.wearweather.controller;

import org.hibernate.service.spi.InjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class HyunjiController {

    // 로그인 폼
    @GetMapping("/login")
    public String login() {return "/user/login";}







}