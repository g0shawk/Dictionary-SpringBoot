package com.dictionary.dictionary_sb.repositories;

import com.dictionary.dictionary_sb.model.Language;
import com.dictionary.dictionary_sb.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface WordRepository extends JpaRepository<Word, Long> {


   // @Modifying
   // @Query(value = "SELECT * FROM Word WHERE Word.eId = :eId", nativeQuery = true)

    //Set<Word> getWordsByLanguage_Id(Long languageId);
    Set<Word> getWordsByLanguage(Language language);

}