package com.myapplicationdev.android.song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShow;
    ListView songList;
    EditText songTitle, singers, year;
    ArrayList<Song> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        songList = findViewById(R.id.songList);
        songTitle = findViewById(R.id.editTextTitle);
        singers = findViewById(R.id.editTextSingers);
        year = findViewById(R.id.editTextYear);

        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,);
        songList.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(MainActivity.this);

                String title = songTitle.getText().toString();
                String singer = singers.getText().toString();
                int y = year.getText().getString();
                db.insertSong(title, singer, y);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(MainActivity.this);

                ArrayList<String> data = db.getSongContent();

                al.addAll(db.getSong());
                adapter.notifyDataSetChanged();

                db.close();
            }
        });
    }
}