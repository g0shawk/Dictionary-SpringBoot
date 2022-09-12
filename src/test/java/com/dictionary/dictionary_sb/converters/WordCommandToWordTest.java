package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.WordCommand;
import com.dictionary.dictionary_sb.model.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCommandToWordTest {

    public static final Long ID_VALUE = 1L;

    WordCommandToWord converter;

    @BeforeEach
    public void setUp() throws Exception{
        converter = new WordCommandToWord();
    }

    @Test
    public void testNullObject() throws  Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new WordCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        WordCommand wordCommand = new WordCommand();
        wordCommand.setId(ID_VALUE);

        //when
        Word word = converter.convert(wordCommand);

        //then
        assertEquals(ID_VALUE, word.getId());

    }

}