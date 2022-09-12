package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.converters.LanguageCommandToLanguage;
import com.dictionary.dictionary_sb.converters.LanguageToLanguageCommand;
import com.dictionary.dictionary_sb.model.Language;
import com.dictionary.dictionary_sb.repositories.LanguageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LanguageServiceTest {


    LanguageService languageService;

    @Mock
    LanguageRepository languageRepository;

    @Mock
    LanguageCommandToLanguage languageCommandToLanguage;

    @Mock
    LanguageToLanguageCommand languageToLanguageCommand;

    @BeforeEach
    public void setUp() throws Exception {
       // MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);

        languageService = new LanguageService(languageRepository, languageCommandToLanguage, languageToLanguageCommand);
    }

    @Test
    public void getLanguagesTest() throws Exception {

        Language language = new Language();
        Set<Language> languagesData = new HashSet();
        languagesData.add(language);

        //when(languageService.getLanguages()).thenReturn(languagesData);

        doReturn(languagesData).when(languageService).getLanguages();

        Set<Language> languages = languageService.getLanguages();

        assertEquals(1, languages.size());
        verify(languageRepository, times(1)).findAll();
        //verify(languageRepository, never()).findById(anyLong());
    }

}