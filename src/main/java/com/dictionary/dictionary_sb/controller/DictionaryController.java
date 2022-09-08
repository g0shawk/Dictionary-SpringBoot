package com.dictionary.dictionary_sb.controller;

import com.dictionary.dictionary_sb.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dictionary")
@Controller
public class DictionaryController {

    private final WordService wordService;

    public DictionaryController(WordService wordService) {
        this.wordService = wordService;
    }


    @GetMapping({ "/{languageId}"})
    public String getDictionaryById(@PathVariable Long languageId, Model model){
        model.addAttribute("words", wordService.getAllByLanguage(languageId));
        return "dictionary";
    }

/*
    @GetMapping({ "/{languageId}"})
    public ModelAndView getDictionaryById(@PathVariable Long languageId){
        ModelAndView mav = new ModelAndView("dictionary/languageId");
        mav.addObject(wordService.findById(languageId));
        return mav;
    }
*/

}
