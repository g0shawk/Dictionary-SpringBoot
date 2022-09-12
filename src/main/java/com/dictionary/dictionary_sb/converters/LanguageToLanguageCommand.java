package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.model.Language;
import com.sun.istack.NotNull;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LanguageToLanguageCommand implements Converter<Language, LanguageCommand> {

    @NotNull
    @Synchronized
    @Override
    public LanguageCommand convert(Language source) {

        if(source == null)
            return  null;

        final LanguageCommand languageCommand = new LanguageCommand();
        languageCommand.setLanguageId(source.getLanguageId());
        languageCommand.setLanguageName(source.getLanguageName());
        languageCommand.setForeignLanguage(source.getForeignLanguage());
        languageCommand.setForeignLanguage(source.getMotherLanguage());

        return languageCommand;
    }
}
