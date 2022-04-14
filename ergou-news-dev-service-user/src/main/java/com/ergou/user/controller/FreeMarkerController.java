package com.ergou.user.controller;

import com.ergou.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeMarkerController {

    @GetMapping("/free/hello")
    public String getFreeMarker(Model model) {
        String stranger = "hello 二狗子～";
        model.addAttribute("there", stranger);
        buildModel(model);
        return "stu";
    }

    private Model buildModel(Model model) {
        User user = User.builder()
                .name("二狗")
                .age(10)
                .address("武汉")
                .amount(99)
                .build();
        model.addAttribute("user", user);
        return model;
    }

}
