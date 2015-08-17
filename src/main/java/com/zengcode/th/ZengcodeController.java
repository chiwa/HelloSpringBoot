package com.zengcode.th;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ZengcodeController {

    @RequestMapping(value = "/helloworld.html")
    public String hydra(Model model) {
        model.addAttribute("title", "test freemarker");
        return "hello";
    }
}
