package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.converters.LanguageCommandToLanguage;
import com.dictionary.dictionary_sb.converters.LanguageToLanguageCommand;
import com.dictionary.dictionary_sb.model.Language;
import com.dictionary.dictionary_sb.repositories.LanguageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    private final LanguageCommandToLanguage languageCommandToLanguage;

    private  final LanguageToLanguageCommand languageToLanguageCommand;

    public LanguageService(LanguageRepository languageRepository, LanguageCommandToLanguage languageCommandToLanguage,
                           LanguageToLanguageCommand languageToLanguageCommand) {
        this.languageRepository = languageRepository;
        this.languageCommandToLanguage = languageCommandToLanguage;
        this.languageToLanguageCommand = languageToLanguageCommand;
    }

    public Set<LanguageCommand> getLanguageCommands() {
        //languageRepository.findAll().iterator().forEachRemaining(languageSet::add);
        Set<LanguageCommand> languageCommands = new HashSet<>();
        languageRepository.findAll().forEach(
                language -> {languageCommands.add(languageToLanguageCommand.convert(language));
                });

        return languageCommands;
    }



    @Transactional
    public LanguageCommand saveLanguageCommand(LanguageCommand command){

        Language detachedLanguage = languageCommandToLanguage.convert(command);

        Language savedLanguage = languageRepository.save(detachedLanguage);
        System.out.println("Inside: saveLanguageCommand(LanguageCommand command)");
        return languageToLanguageCommand.convert(savedLanguage);
    }
}
