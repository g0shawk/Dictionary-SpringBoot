package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.WordCommand;
import com.dictionary.dictionary_sb.model.Word;
import com.sun.istack.NotNull;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WordToWordCommand implements Converter<Word, WordCommand> {

    @NotNull
    @Synchronized
    @Override
    public WordCommand convert(Word source) {

        if (source == null)
            return null;

        final WordCommand wordCommand = new WordCommand();
        wordCommand.setId(source.getId());
        wordCommand.setExpression(source.getExpression());
        wordCommand.setLanguage(source.getLanguage());
        wordCommand.setTranslation(source.getTranslation());

        return wordCommand;
    }
}
