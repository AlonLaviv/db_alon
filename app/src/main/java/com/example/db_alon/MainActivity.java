package com.example.db_alon;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button button;
    Random rn;
    List<Note> noteList;
    NoteDAO noteDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });







        NoteDatabase database = NoteDatabase.getInstance(this);
        noteDAO = database.noteDao();
        rn = new Random();

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);


        new Thread(new Runnable() {
            @Override
            public void run() {
                if (noteDAO.getAllNotes().isEmpty()) { // Avoid inserting duplicates
                    noteDAO.insert(new Note("hello", 3, "30%"));
                    noteDAO.insert(new Note("hi", 4, "40%"));
                    noteDAO.insert(new Note("yo", 5, "60%"));
                }
            }
        }).start();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteList = noteDAO.getAllNotes();
                int randomIndex = rn.nextInt(noteList.size());
                Note randomNote = noteList.get(randomIndex);
                textView.setText("ID: " + randomNote.getId() +"\nWords: " + randomNote.getWords() +"\nNumber: " + randomNote.getNumber() +"\nPercentage: " + randomNote.getA_hoze());
            }
        });
    }
}