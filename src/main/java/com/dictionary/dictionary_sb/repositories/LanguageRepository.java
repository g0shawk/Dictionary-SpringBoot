package com.dictionary.dictionary_sb.repositories;

import com.dictionary.dictionary_sb.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LanguageRepository extends JpaRepository<Language, Long> {
}
