package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.model.Language;
import com.sun.istack.NotNull;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LanguageCommandToLanguage implements Converter<LanguageCommand, Language> {

    @NotNull
    @Synchronized
    @Override
    public Language convert(LanguageCommand source) {

        final Language language = new Language();
        language.setLanguageId(source.getLanguageId());
        language.setLanguageName(source.getLanguageName());
        language.setForeignLanguage(source.getForeignLanguage());
        language.setForeignLanguage(source.getMotherLanguage());

        return language;
    }
}
