package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.WordCommand;
import com.dictionary.dictionary_sb.model.Word;
import com.sun.istack.NotNull;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WordCommandToWord implements Converter<WordCommand, Word> {

    @NotNull
    @Synchronized
    @Override
    public Word convert(WordCommand source) {

        if (source == null)
            return null;

        final Word word = new Word();
        word.setId(source.getId());
        word.setExpression(source.getExpression());
        word.setLanguage(source.getLanguage());
        word.setTranslation(source.getTranslation());

        return word;
    }
}
