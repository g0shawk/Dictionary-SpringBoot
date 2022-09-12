package com.dictionary.dictionary_sb.converters;

import com.dictionary.dictionary_sb.commands.WordCommand;
import com.dictionary.dictionary_sb.model.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordToWordCommandTest {

    public static final Long ID_VALUE = 1L;

    WordToWordCommand converter;

    @BeforeEach
    public void setUp() throws Exception{
        converter = new WordToWordCommand();
    }

    @Test
    public void testNullObject() throws  Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Word()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Word word = new Word();
        word.setId(ID_VALUE);

        //when
        WordCommand wordCommand = converter.convert(word);

        //then
        assertEquals(ID_VALUE, wordCommand.getId());

    }

}