package com.dictionary.dictionary_sb.repositories;

import com.dictionary.dictionary_sb.model.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface WordRepository extends CrudRepository<Word, Long> {


   // @Modifying
   // @Query(value = "SELECT * FROM Word WHERE Word.eId = :eId", nativeQuery = true)
    Set<Word> getAllByLanguage(Long languageId);

}