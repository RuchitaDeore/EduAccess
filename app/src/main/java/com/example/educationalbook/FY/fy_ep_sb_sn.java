package com.example.educationalbook.FY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.FY.sb_fy.sb_fy_bca;
import com.example.educationalbook.FY.sb_fy.sb_fy_cp;
import com.example.educationalbook.R;

public class fy_ep_sb_sn extends AppCompatActivity {
    ImageView fyback;
    ImageView sbfy;
    ImageView snfy;
    ImageView epfy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fy_ep_sb_sn);

        sbfy = findViewById(R.id.sb_fy);
        snfy = findViewById(R.id.sn_fy);
        epfy = findViewById(R.id.ep_fy);
        fyback = findViewById(R.id.fy_back);

        fyback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), fy_main.class);
                startActivity(i);
            }
        });
        sbfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), sb_fy_bca.class);
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