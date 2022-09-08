package com.dictionary.dictionary_sb.repositories;

import com.dictionary.dictionary_sb.model.Language;
import org.springframework.data.repository.CrudRepository;



public interface LanguageRepository extends CrudRepository<Language, Long> {
}
