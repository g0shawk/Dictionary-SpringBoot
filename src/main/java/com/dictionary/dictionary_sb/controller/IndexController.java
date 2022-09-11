package com.dictionary.dictionary_sb.controller;


import com.dictionary.dictionary_sb.services.LanguageService;
import com.dictionary.dictionary_sb.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final WordService wordService;

    private final LanguageService languageService;

    public IndexController(WordService wordService, LanguageService languageService) {
        this.wordService = wordService;
        this.languageService = languageService;
    }

    @GetMapping({"", "/", "/index"})
    public String getLanguages(Model model){
        model.addAttribute("languages",languageService.getLanguages());
        return "index";
    }

/*
    @PostMapping({"/index"})
    public String changeLanguage(Model model){
        model.addAttribute("selectedLanguage", languageService.getLanguages());
        Language.setSelectedLanguageId(selectedLanguage);
        return "index";
    }*/
}
