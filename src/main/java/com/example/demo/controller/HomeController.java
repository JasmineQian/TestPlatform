package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping({"/", "/index", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping("/underBuild")
    public String underBuild() {
        return "underBuild";
    }

    @GetMapping("/news")
    public String news() {return "about/news";}

    @GetMapping("/contact")
    public String contact() {return "about/contact";}

    @GetMapping("/guide")
    public String guide() {return "about/guide";}


    @GetMapping("/donate")
    public String donate() {return "about/donate";}


}
