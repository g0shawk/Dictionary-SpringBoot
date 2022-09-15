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

    public WordService(WordRepository wordRepository, WordToWordCommand wordToWordCommand,
                       WordCommandToWord wordCommandToWord, LanguageToLanguageCommand languageToLanguageCommand,
                       LanguageCommandToLanguage languageCommandToLanguage) {
        this.wordRepository = wordRepository;
        this.wordToWordCommand = wordToWordCommand;
        this.wordCommandToWord = wordCommandToWord;
        this.languageToLanguageCommand = languageToLanguageCommand;
        this.languageCommandToLanguage = languageCommandToLanguage;
    }

    /*
    public Set<Word> getWords() {
        Set<Word> wordSet = new HashSet<>();
        wordRepository.findAll().iterator().forEachRemaining(wordSet::add);
        return wordSet;
    }*/

    public WordCommand findById(Long long1) { Word word = wordRepository.findById(long1).orElse(null);
        return wordToWordCommand.convert(word);}

    public WordCommand save(WordCommand wordCommand) {
        Word word = wordRepository.save(wordCommandToWord.convert(wordCommand));
        return  wordToWordCommand.convert(word);}

    public void delete(Long aLong) {
        wordRepository.deleteById(aLong);
    }

    public WordCommand editExpression(WordCommand wordCommand){
        Long id = wordCommand.getId();
        if(wordRepository.editExpession(wordCommand.getExpression(), wordCommand.getTranslation(),
                wordCommand.getId()))
            return wordCommand;
        else return null;

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

    public void deleteByLanguage(LanguageCommand languageCommand){
        Long aLong = languageCommand.getLanguageId();
        Set<Long> longs = new HashSet<>();

        wordRepository.getWordsByLanguage(languageCommandToLanguage.convert(languageCommand)).stream()
                        .forEach(word -> longs.add(word.getId()));

        wordRepository.deleteAllById(longs);
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