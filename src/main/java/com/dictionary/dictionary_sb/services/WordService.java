package com.dictionary.dictionary_sb.services;

import com.dictionary.dictionary_sb.model.Word;
import com.dictionary.dictionary_sb.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WordService{

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
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
/*
    @Query("")
    public Set<Word> findbyRegex(String match, Language language) { }

    */

}