package com.example.db_alon;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String words;
    private Integer number;
    private String a_hoze;

    public Note(String words, Integer number, String a_hoze) {
        this.words = words;
        this.number = number;
        this.a_hoze = a_hoze;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWords() {
        return words;
    }

    public String getA_hoze() {
        return a_hoze;
    }

    public void setA_hoze(String a_hoze) {
        this.a_hoze = a_hoze;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
