package com.dictionary.dictionary_sb.model;

import javax.persistence.*;

@Table(name="Language")
@Entity
public class Language {

    @Column(name="eId", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eId;

    @Column(name="languageName", nullable = false)
    private String languageName;
    @Column(name="foreignLanguage", nullable = false)
    private String foreignLanguage;

    @Column(name="motherLanguage", nullable = false)
    private String motherLanguage;

    public Long getId() {
        return eId;
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


}
