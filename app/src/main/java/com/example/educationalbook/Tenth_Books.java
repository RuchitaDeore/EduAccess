package com.example.educationalbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.tenth.exam_paper_10.exam_paper_10;
import com.example.educationalbook.tenth.short_notes_10.short_notes_10;
import com.example.educationalbook.tenth.study_books_10.study_books_10;

public class Tenth_Books extends AppCompatActivity {

    ImageView sb10;
    ImageView sn10;
    ImageView ep10;
    ImageView thback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tenth_books);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sb10 = findViewById(R.id.sb_10);
        sn10 = findViewById(R.id.sn_10);
        ep10 = findViewById(R.id.ep_10);
        thback = findViewById(R.id.tenth_back);
        thback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        sb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), study_books_10.class);
                startActivity(i);
                finish();
            }
        });
        sn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), short_notes_10.class);
                startActivity(i);
                finish();
            }
        });
        ep10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), exam_paper_10.class);
                startActivity(i);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}