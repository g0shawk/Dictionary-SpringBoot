package com.dictionary.dictionary_sb.repositories;

import com.dictionary.dictionary_sb.model.Language;
import com.dictionary.dictionary_sb.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {


    Set<Word> getWordsByLanguage(Language language);

    //Saves an entity of "Word"
    @Override
    Word  save(Word word);

    //Deletes expression from table "Word"
    @Override
    void deleteById(Long aLong);

    //Deletes all entityd of "Word" by id-s
    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    //Editing expression

    @Modifying
    @Query("UPDATE Word " +
            "SET expression = ?1 ,  translation = ?2 WHERE id = ?3" )
    boolean editExpession(String expression, String translation, Long id);


    //Deletes all from the table "Word"
    @Override
    void deleteAll();

}