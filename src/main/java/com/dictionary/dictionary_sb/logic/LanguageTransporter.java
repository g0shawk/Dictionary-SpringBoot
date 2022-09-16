package com.dictionary.dictionary_sb.logic;

import com.dictionary.dictionary_sb.commands.LanguageCommand;

public class LanguageTransporter {

    private static boolean languageAvailable = false;
    private static LanguageCommand languageCommand;

    public static boolean isLanguageAvailable() {
        return languageAvailable;
    }

    public static void setSelectedLanguage(LanguageCommand languageCommand) {
        LanguageTransporter.languageCommand = languageCommand;
        languageAvailable = true;
    }

    public static LanguageCommand getSelectedLanguage() {
        return languageCommand;
    }
    public static void deleteSelectedLanguageFromSession(){
        LanguageTransporter.languageCommand = null;
        languageAvailable = false;
    }
}
