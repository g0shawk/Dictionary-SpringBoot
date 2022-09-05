package com.dictionary.dictionary_sb.bootstrap;

import com.dictionary.dictionary_sb.model.Language;
import com.dictionary.dictionary_sb.model.Word;
import com.dictionary.dictionary_sb.repositories.LanguageRepository;
import com.dictionary.dictionary_sb.repositories.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private  final WordRepository wordRepository;

    private  final LanguageRepository languageRepository;

    public Bootstrap(WordRepository wordRepository, LanguageRepository languageRepository) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Language language1 = new Language();
        language1.setLanguageName("Engleski");
        language1.setForeignLanguage("en");
        language1.setMotherLanguage("hr");

        Language language2 = new Language();
        language2.setLanguageName("Njemački");
        language2.setForeignLanguage("de");
        language2.setMotherLanguage("hr");


        Word word1 = new Word();
        word1.setExpression("table");
        word1.setTranslation("stol");
        word1.setLanguage(language1);

        Word word2 = new Word();
        word2.setExpression("arbeit");
        word2.setTranslation("posao");
        word2.setLanguage(language2);

        // Najprije se mora snimiti language a tek onda riječ

        languageRepository.save(language1);
        languageRepository.save(language2);

        wordRepository.save(word1);
        wordRepository.save(word2);


    }
}
