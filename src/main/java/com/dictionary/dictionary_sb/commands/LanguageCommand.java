package com.dictionary.dictionary_sb.commands;

import com.sun.istack.NotNull;

public class LanguageCommand {
    @NotNull
    private Long languageId;

    @NotNull
    private String languageName;

    @NotNull
    private String foreignLanguage;

    @NotNull
    private String motherLanguage;

    @NotNull
    private static Long selectedLanguageId;

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(String foreignLanguage) {
        this.foreignLanguage = foreignLanguage;
    }

    public String getMotherLanguage() {
        return motherLanguage;
    }

    public void setMotherLanguage(String motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    public  Long getSelectedLanguageId() {
        return selectedLanguageId;
    }

    public  void setSelectedLanguageId(Long selectedLanguageId) {
        LanguageCommand.selectedLanguageId = selectedLanguageId;
    }
}
