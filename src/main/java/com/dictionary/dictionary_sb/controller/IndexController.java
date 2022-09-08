package com.dictionary.dictionary_sb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /*
    private final LanguageService languageService;

    public IndexController(LanguageService languageService) {
        this.languageService = languageService;
    }

*/
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        return "index";
    }

}
