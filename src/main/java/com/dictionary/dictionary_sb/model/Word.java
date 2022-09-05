package com.dictionary.dictionary_sb.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name="Word")
@Entity
public class Word {

    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
    @Column(name="languageId", nullable = false)
    @OneToOne
    @JoinColumn(name="eId")
    private Long languageId;
*/

    @OneToOne
    @JoinColumn(name="eId")
    private Language language;

    @Column(name="expression", nullable = false)
    private  String expression;

    @Column(name="translation")
    @NotNull
    private  String translation;

    public Long getId() {
        return id;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
