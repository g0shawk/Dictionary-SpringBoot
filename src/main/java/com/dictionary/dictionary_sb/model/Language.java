package com.dictionary.dictionary_sb.model;

import javax.persistence.*;

@Table(name="Language")
@Entity
public class Language {

    @Column(name="languageId", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;

    @Column(name="languageName", nullable = false)
    private String languageName;
    @Column(name="foreignLanguage", nullable = false)
    private String foreignLanguage;

    @Column(name="motherLanguage", nullable = false)
    private String motherLanguage;

    private static Long selectedLanguageId;

    public Long getId() {
        return languageId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(String language) {
        this.foreignLanguage = language;
    }

    public String getMotherLanguage() {
        return motherLanguage;
    }

    public void setMotherLanguage(String motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public  Long getSelectedLanguageId() {
        return selectedLanguageId;
    }
    public  void setSelectedLanguageId(Long selectedLanguageId) {
        selectedLanguageId = selectedLanguageId;
    }
}
