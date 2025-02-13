package com.runlala.scaffold.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("greeting", "Hello SpringBootScaffold!");
        return "index";
    }

    @GetMapping("/health")
    @ResponseBody
    public int health() {
        return 1;
    }
}
