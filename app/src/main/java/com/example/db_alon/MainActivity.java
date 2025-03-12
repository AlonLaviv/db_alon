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
    Random rnd;
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
        rnd = new Random();
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (noteDAO.getAllNotes().isEmpty()) {
                    noteDAO.insert(new Note("alon", 3, "10%"));
                    noteDAO.insert(new Note("ben", 4, "30%"));
                    noteDAO.insert(new Note("karin", 5, "40%"));
                    noteDAO.insert(new Note("shai", 6, "20%"));
                }
            }
        }).start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteList = noteDAO.getAllNotes();
                int randomIndex = rnd.nextInt(noteList.size());
                Note randomNote = noteList.get(randomIndex);
                textView.setText("ID: " + randomNote.getId() + "\nWord: " + randomNote.getWords() + "\nNumber: " + randomNote.getNumber() + "\nPercentage: " + randomNote.getPercent());
            }
        });
    }
}