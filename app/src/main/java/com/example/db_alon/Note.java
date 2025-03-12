package com.example.db_alon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String words;
    private Integer number;
    private String percent;
    public Note(String words, Integer number, String percent){
        this.words = words;
        this.number = number;
        this.percent = percent;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Integer getNumber() {return number;}
    public void setNumber(Integer number) {this.number = number;}
    public String getWords() {return words;}
    public void setWords(String words) {this.words = words;}
    public String getPercent() {return percent;}
    public void setPercent(String percent) {this.percent = percent;}
}
