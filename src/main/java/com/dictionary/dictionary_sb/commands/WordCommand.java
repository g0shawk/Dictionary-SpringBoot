package com.dictionary.dictionary_sb.commands;

import com.dictionary.dictionary_sb.model.Language;
import com.sun.istack.NotNull;

public class WordCommand {

    @NotNull
    private Long id;

    @NotNull
    private Language language;

    @NotNull
    private  String expression;

    @NotNull
    private  String translation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
