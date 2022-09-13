package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.commands.LanguageCommand;
import com.dictionary.dictionary_sb.commands.WordCommand;
import com.dictionary.dictionary_sb.converters.LanguageCommandToLanguage;
import com.dictionary.dictionary_sb.converters.LanguageToLanguageCommand;
import com.dictionary.dictionary_sb.converters.WordCommandToWord;
import com.dictionary.dictionary_sb.converters.WordToWordCommand;
import com.dictionary.dictionary_sb.model.Word;
import com.dictionary.dictionary_sb.repositories.WordRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WordService{

    private final WordRepository wordRepository;

    private final WordToWordCommand wordToWordCommand;

    private final WordCommandToWord wordCommandToWord;

    private  final LanguageToLanguageCommand languageToLanguageCommand;

    private  final LanguageCommandToLanguage languageCommandToLanguage;

    public WordService(WordRepository wordRepository, WordToWordCommand wordToWordCommand, WordCommandToWord wordCommandToWord, LanguageToLanguageCommand languageToLanguageCommand, LanguageCommandToLanguage languageCommandToLanguage) {
        this.wordRepository = wordRepository;
        this.wordToWordCommand = wordToWordCommand;
        this.wordCommandToWord = wordCommandToWord;
        this.languageToLanguageCommand = languageToLanguageCommand;
        this.languageCommandToLanguage = languageCommandToLanguage;
    }

    public Set<Word> getWords() {
        Set<Word> wordSet = new HashSet<>();
        wordRepository.findAll().iterator().forEachRemaining(wordSet::add);
        return wordSet;
    }

    public Word findById(Long long1) { return wordRepository.findById(long1).orElse(null);}

    public Word save(Word word) { return wordRepository.save(word); }

    public void delete(Word word) {
        wordRepository.delete(word);
    }

    public Set<WordCommand> getWordsByLanguage(LanguageCommand languageCommand) {
        Set<Word> words = wordRepository.getWordsByLanguage(languageCommandToLanguage.convert(languageCommand));

        Set<WordCommand> wordCommands = new HashSet<>();

        words.stream().forEach(
                word -> {
                    wordCommands.add(wordToWordCommand.convert(word));
                }
        );
        return wordCommands;
    }
/*
    @Transactional
    public WordCommand saveLanguageCommand(WordCommand
     command){

        Word detachedWord = wordCommandToWord.convert(command);

        Word savedWord = wordRepository.save(detachedWord);
        System.out.println("Inside: saveLanguageCommand(WordCommand command)");
        return wordToWordCommand.convert(savedWord);
    }
*/
}