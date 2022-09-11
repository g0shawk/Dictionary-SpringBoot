package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.commands.WordCommand;
import com.dictionary.dictionary_sb.converters.WordCommandToWord;
import com.dictionary.dictionary_sb.converters.WordToWordCommand;
import com.dictionary.dictionary_sb.model.Language;
import com.dictionary.dictionary_sb.model.Word;
import com.dictionary.dictionary_sb.repositories.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class WordService{

    private final WordRepository wordRepository;

    private final WordToWordCommand wordToWordCommand;

    private final WordCommandToWord wordCommandToWord;

    public WordService(WordRepository wordRepository, WordToWordCommand wordToWordCommand, WordCommandToWord wordCommandToWord) {
        this.wordRepository = wordRepository;
        this.wordToWordCommand = wordToWordCommand;
        this.wordCommandToWord = wordCommandToWord;
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

    public Set<Word> getWordsByLanguage(Language language) {
        return wordRepository.getWordsByLanguage(language);}

    @Transactional
    public WordCommand saveLanguageCommand(WordCommand command){

        Word detachedWord = wordCommandToWord.convert(command);

        Word savedWord = wordRepository.save(detachedWord);

        return wordToWordCommand.convert(savedWord);
    }

}