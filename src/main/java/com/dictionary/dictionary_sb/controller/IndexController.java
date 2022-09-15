package com.dictionary.dictionary_sb.controller;


import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.services.LanguageService;
import com.dictionary.dictionary_sb.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public String getDictionaryById(@RequestParam String languageName, Model model) {

        LanguageCommand languageCommand = languageService.findLanguageByLanguageName(languageName);
        System.out.println("$$$$$$$$$$$$$$$$$ languageName = " + languageName);
        model.addAttribute("selectedLanguage", languageService.findLanguageByLanguageName(languageName));
        LanguageTransporter.setSelectedLanguage(languageCommand);

        return "index";
    }


    @ModelAttribute
    public void initSelectedLang(Model model){
        System.out.println("################################# inside initSelectedLang");
        LanguageCommand languageCommand;
        if(LanguageTransporter.isLanguageAvailable())
            languageCommand = LanguageTransporter.getSelectedLanguage();
        else languageCommand = null;
        model.addAttribute("selectedLanguage", languageCommand);
    }

    @GetMapping({"", "/", "/index"})
    public String getLanguages(Model model) {
        Set<LanguageCommand> languageCommands =  languageService.getLanguageCommands();
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

    /*
    @PostMapping
    public String getDictionaryById(@RequestParam String languageName, Model model){

        System.out.println("$$$$ languageName = " + languageName);
        Set<LanguageCommand> languageCommands = languageService.getLanguageCommands();

        Optional<LanguageCommand> matchingObject = languageCommands.stream().filter(
                languageCommand -> languageCommand.getLanguageName()
                .equals(languageName)).findFirst();

        model.addAttribute("words", wordService.getWordsByLanguage(matchingObject.get()));
        return "dictionary";
    }
    */

}