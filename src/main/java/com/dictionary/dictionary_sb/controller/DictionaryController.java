package com.dictionary.dictionary_sb.controller;

import com.dictionary.dictionary_sb.services.LanguageService;
import com.dictionary.dictionary_sb.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.dictionary.dictionary_sb.logic.LanguageTransporter.getSelectedLanguage;
import static com.dictionary.dictionary_sb.logic.LanguageTransporter.isLanguageAvailable;

@RequestMapping("/dictionary")
@Controller
public class DictionaryController {

    private final WordService wordService;

    private final LanguageService languageService;

    public DictionaryController(WordService wordService, LanguageService languageService) {
        this.wordService = wordService;
        this.languageService = languageService;
    }

/*
    @GetMapping({ "/{languageName}"})
    public String getDictionaryById(@PathVariable String languageName, Model model){

        if(isLanguageAvailable())
            languageName = getSelectedLanguage().getLanguageName();

        Set<LanguageCommand> languageCommands = languageService.getLanguageCommands();

        Optional<LanguageCommand> matchingObject = languageCommands.stream().filter(
                languageCommand -> languageCommand.getLanguageName()
                .equals(languageName)).findFirst();

        model.addAttribute("words", wordService.getWordsByLanguage(matchingObject.get()));
        return "dictionary";

    }*/

    @GetMapping({ "/{languageName}"})
    public String getDictionaryById( String languageName, Model model){

        if(isLanguageAvailable()){
            languageName = getSelectedLanguage().getLanguageName();

            model.addAttribute("words", wordService.getWordsByLanguage(getSelectedLanguage()));
            return "dictionary";
        }
        else return "errors/no_language";

    }




    /*
    @GetMapping
    public String getDictionaryById(@RequestParam String languageName, Model model) {

        LanguageCommand languageCommand = languageService.findLanguageByLanguageName(languageName);
        System.out.println("$$$$$$$$$$$$$$$$$ languageName = " + languageName);
        model.addAttribute("selectedLanguage", languageService.findLanguageByLanguageName(languageName));
        LanguageTransporter.setSelectedLanguage(languageCommand);

        return "index";*/



}
