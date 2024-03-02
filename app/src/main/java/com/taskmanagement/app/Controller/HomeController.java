package com.taskmanagement.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class HomeController implements WebMvcConfigurer {


    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
}
