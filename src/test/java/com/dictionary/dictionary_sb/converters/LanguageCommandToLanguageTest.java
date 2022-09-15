package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.model.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageCommandToLanguageTest {

    public static final Long ID_VALUE = 1L;

    LanguageCommandToLanguage converter;

    @BeforeEach
    public void setUp() throws Exception{
        converter = new LanguageCommandToLanguage();
    }

    @Test
    public void testNullObject() throws  Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new LanguageCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        LanguageCommand languageCommand = new LanguageCommand();
        languageCommand.setLanguageId(ID_VALUE);

        //when
        Language language = converter.convert(languageCommand);

        //then
        assertEquals(ID_VALUE, language.getLanguageId());

    }


}