package com.example.internshipbaba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class twentyone extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twentyone);
        t1=(TextView) findViewById(R.id.yo);
        t2=(TextView) findViewById(R.id.yo1);
        t3=(TextView) findViewById(R.id.yo2);
        t4=(TextView) findViewById(R.id.yo3);
        b1=(Button) findViewById(R.id.yo4);
        b2=(Button) findViewById(R.id.yo5);

        t4.setText("Score"  +  twelve.score);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(twentyone.this, eleven.class);
                startActivity(i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(twentyone.this, nine.class);
                startActivity(j);
                finish();
            }
        });
    }
}