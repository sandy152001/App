package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class eighteen extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView t1;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eighteen);
        r1=(RadioButton) findViewById(R.id.radio24);
        r2=(RadioButton) findViewById(R.id.radio25);
        r3=(RadioButton) findViewById(R.id.radio26);
        r4=(RadioButton) findViewById(R.id.radio27);
        t1=(TextView) findViewById(R.id.spider6);
        b1=(Button) findViewById(R.id.man6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r4.isChecked()) {
                    ++twelve.score;
                }else {
                    --twelve.score;
                }
                Intent i=new Intent(eighteen.this, nineteen.class);
                startActivity(i);
                finish();
            }
        });
    }
}