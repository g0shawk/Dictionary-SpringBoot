package com.dictionary.dictionary_sb.repositories;

import com.dictionary.dictionary_sb.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LanguageRepository extends JpaRepository<Language, Long> {

    //Finds a language by its name
    Language findLanguageByLanguageName(String languageName);

    //Deletes all languages from the table "Language"
    //Referential integrity must be taken into account
    @Override
    void deleteAll();

    //Deletes a language from the table "Language"
    //Referential integrity must be taken into account
    @Override
    void delete(Language language);
}
