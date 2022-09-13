package com.dictionary.dictionary_sb.controller;


import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.services.LanguageService;
import com.dictionary.dictionary_sb.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class IndexController {

    private static Long selectedLanguageId;

    private final WordService wordService;

    private final LanguageService languageService;

    public IndexController(WordService wordService, LanguageService languageService) {
        this.wordService = wordService;
        this.languageService = languageService;
    }

    @GetMapping({"", "/", "/index"})
    public String getLanguages(Model model) {
        Set<LanguageCommand> languagCommands =  languageService.getLanguageCommands();
        model.addAttribute("languages", languageService.getLanguageCommands());
        return "index";
    }

/*
    @PostMapping({"/index"})
    public String changeLanguage(Model model){
        model.addAttribute("selectedLanguage", languageService.getLanguages());
        Language.setSelectedLanguageId(selectedLanguage);
        return "index";
    }*/

    @RequestMapping(value = "/changeLanguage", method = RequestMethod.POST, params = "submit")
    public String changeLanguage(@Validated @ModelAttribute("selectedLanguage") final Long language,
                                 //final BindingResult result,
                                 final ModelMap modelMap)
    {
        System.out.println("tipka radi");
        //languageService.g
        /*
        model.addAttribute("selectedLanguage", languageService.getLanguages());
        Language.setSelectedLanguageId(selectedLanguage);
        return "index";*/
        //modelMap.addAttribute("changeLanguage", )
        return "index";
    }
}