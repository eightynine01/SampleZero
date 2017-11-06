package com.sample.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by TaeHwan
 * 2017. 11. 6. AM 8:51
 */
@Controller
public class MainController {
    @GetMapping("/")
    public String mainSwaggerPage(){
        return "redirect:swagger-ui.html";
    }
}
