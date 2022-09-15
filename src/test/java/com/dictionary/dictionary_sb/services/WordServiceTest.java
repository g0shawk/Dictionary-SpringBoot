package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.commands.WordCommand;
import com.dictionary.dictionary_sb.converters.LanguageCommandToLanguage;
import com.dictionary.dictionary_sb.converters.LanguageToLanguageCommand;
import com.dictionary.dictionary_sb.converters.WordCommandToWord;
import com.dictionary.dictionary_sb.converters.WordToWordCommand;
import com.dictionary.dictionary_sb.model.Language;
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
    private  WordRepository wordRepository;
    @Mock
    private  WordToWordCommand wordToWordCommand;

    @Mock
    private  WordCommandToWord wordCommandToWord;

    @Mock
    private   LanguageToLanguageCommand languageToLanguageCommand;

    @Mock
    private   LanguageCommandToLanguage languageCommandToLanguage;

    @Mock
    LanguageService languageService;



    @BeforeEach
    public void setUp() throws Exception {
        // MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);

        //wordService = new WordService(wordRepository, wordCommandToWord, wordToWordCommand);

        wordService = new WordService(wordRepository, wordToWordCommand,
                wordCommandToWord, languageToLanguageCommand, languageCommandToLanguage);
    }


    //Does not work
    @Test
    public void getLanguagesTest() throws Exception {

        Word word = new Word();
        Set<Word> wordsData = new HashSet();
        wordsData.add(word);

        Language language = new Language();

        Set<WordCommand> wordCommands = new HashSet<>();
        wordsData.stream().forEach(
                word1 -> wordCommands.add(wordToWordCommand.convert(word1)));

        when(wordService.getWordsByLanguage(languageToLanguageCommand.convert(language))).thenReturn(wordCommands);

        //doReturn(wordsData).when(wordService).getWordsByLanguage(languageToLanguageCommand.convert(language));

        Set<WordCommand> words = wordService.getWordsByLanguage(languageToLanguageCommand.convert(language));

        assertEquals(1, words.size());
        verify(wordRepository, times(1)).findAll();
        verify(wordRepository, never()).findById(anyLong());
    }


}