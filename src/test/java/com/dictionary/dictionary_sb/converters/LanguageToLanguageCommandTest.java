package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.model.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageToLanguageCommandTest {

    public static final Long ID_VALUE = 1L;

    LanguageToLanguageCommand converter;

    @BeforeEach
    public void setUp() throws Exception{
        converter = new LanguageToLanguageCommand();
    }

    @Test
    public void testNullObject() throws  Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Language()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Language language = new Language();
        language.setLanguageId(ID_VALUE);

        //when
        LanguageCommand languageCommand = converter.convert(language);

        //then
        assertEquals(ID_VALUE, languageCommand.getLanguageId());

    }
}