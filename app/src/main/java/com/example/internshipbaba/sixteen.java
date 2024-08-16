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

public class sixteen extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView t1;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixteen);
        r1=(RadioButton) findViewById(R.id.radio16);
        r2=(RadioButton) findViewById(R.id.radio17);
        r3=(RadioButton) findViewById(R.id.radio18);
        r4=(RadioButton) findViewById(R.id.radio19);
        t1=(TextView) findViewById(R.id.spider4);
        b1=(Button) findViewById(R.id.man4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()) {
                    ++twelve.score;
                }else {
                    --twelve.score;
                }
                Intent i=new Intent(sixteen.this, seventeen.class);
                startActivity(i);
                finish();
            }
        });
    }
}