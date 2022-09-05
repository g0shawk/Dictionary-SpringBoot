package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.model.Language;
import com.dictionary.dictionary_sb.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    public Set<Language> getLanguages() {
        Set<Language> languageSet = new HashSet<>();
        languageRepository.findAll().iterator().forEachRemaining(languageSet::add);
        return languageSet;
    }
}
