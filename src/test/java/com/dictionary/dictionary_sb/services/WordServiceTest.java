package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.converters.WordCommandToWord;
import com.dictionary.dictionary_sb.converters.WordToWordCommand;
import com.dictionary.dictionary_sb.model.Word;
import com.dictionary.dictionary_sb.repositories.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WordServiceTest {
    WordService wordService;

    @Mock
    WordRepository wordRepository;

    @Mock
    WordCommandToWord wordCommandToWord;

    @Mock
    WordToWordCommand wordToWordCommand;

    @BeforeEach
    public void setUp() throws Exception {
        // MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);

        wordService = new WordService(wordRepository, wordCommandToWord, wordToWordCommand);
    }

    @Test
    public void getLanguagesTest() throws Exception {

        Word word = new Word();
        Set<Word> wordsData = new HashSet();
        wordsData.add(word);

        //when(languageService.getLanguages()).thenReturn(languagesData);

        doReturn(wordsData).when(wordService).getWords();

        Set<Word> languages = wordService.getWords();

        assertEquals(1, languages.size());
        verify(wordRepository, times(1)).findAll();
        //verify(wordRepository, never()).findById(anyLong());


    }

}