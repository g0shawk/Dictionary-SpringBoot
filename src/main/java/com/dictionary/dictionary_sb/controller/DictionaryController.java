package com.dictionary.dictionary_sb.controller;

import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.services.LanguageService;
import com.dictionary.dictionary_sb.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/dictionary")
@Controller
public class DictionaryController {

    private final WordService wordService;

    private final LanguageService languageService;

    public DictionaryController(WordService wordService, LanguageService languageService) {
        this.wordService = wordService;
        this.languageService = languageService;
    }


    @GetMapping({ "/{languageName}"})
    public String getDictionaryById(@PathVariable String languageName, Model model){

        Set<LanguageCommand> languageCommands = languageService.getLanguageCommands();

        Optional<LanguageCommand> matchingObject = languageCommands.stream().filter(
                languageCommand -> languageCommand.getLanguageName()
                .equals(languageName)).findFirst();

        model.addAttribute("words", wordService.getWordsByLanguage(matchingObject.get()));
        return "dictionary";

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
