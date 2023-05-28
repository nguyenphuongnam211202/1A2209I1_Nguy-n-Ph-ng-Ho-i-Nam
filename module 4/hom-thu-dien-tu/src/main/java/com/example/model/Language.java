package com.example.model;

public class Language {
    private int idLanguage;
    private String nameLaguege;

    public Language(int idLanguage, String nameLaguege) {
        this.idLanguage = idLanguage;
        this.nameLaguege = nameLaguege;
    }

    public int getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getNameLaguege() {
        return nameLaguege;
    }

    public void setNameLaguege(String nameLaguege) {
        this.nameLaguege = nameLaguege;
    }
}
