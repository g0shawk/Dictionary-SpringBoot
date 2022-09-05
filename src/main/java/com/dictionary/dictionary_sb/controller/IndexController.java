package com.dictionary.dictionary_sb.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndecPage(Model model){
        model.addAttribute("index", "Dictionary - Spring v1.0");
                return "index";
    }
}
