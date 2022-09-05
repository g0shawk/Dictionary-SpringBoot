package com.dictionary.dictionary_sb.repositories;

import com.dictionary.dictionary_sb.model.Word;
import org.springframework.data.repository.CrudRepository;


public interface WordRepository extends CrudRepository<Word, Long> {
}
