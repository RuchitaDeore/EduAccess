package com.example.educationalbook.tenth.short_notes_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.R;
import com.example.educationalbook.Tenth_Books;
import com.example.educationalbook.tenth.study_books_10.English_10_sb;

public class short_notes_10 extends AppCompatActivity {

    ImageView snback;
    ImageView eng_10_btn;
    ImageView hindi_10_btn;
    ImageView math_10_btn;
    ImageView sst_10_btn;
    ImageView sci_10_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_short_notes10);

        snback = findViewById(R.id.sn_back);
        eng_10_btn = findViewById(R.id.sn_eng);
        hindi_10_btn = findViewById(R.id.sn_hindi);
        math_10_btn = findViewById(R.id.sn_maths);
        sst_10_btn = findViewById(R.id.sn_sst);
        sci_10_btn = findViewById(R.id.sn_sci);

        snback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Tenth_Books.class);
                startActivity(i);
                finish();
            }
        });
        eng_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), English_10_sb.class);
                startActivity(i);
            }
        });
        hindi_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Hindi_10_sn.class);
                startActivity(i);
            }
        });
        math_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Maths_10_sn.class);
                startActivity(i);
            }
        });
        sst_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SST_10_sn.class);
                startActivity(i);
            }
        });
        sci_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Science_10_sn.class);
                startActivity(i);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}