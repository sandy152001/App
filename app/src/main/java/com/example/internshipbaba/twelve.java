package com.example.internshipbaba;

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

public class twelve extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView t1;
    Button b1;
    static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twelve);
        r1=(RadioButton) findViewById(R.id.radio);
        r2=(RadioButton) findViewById(R.id.radio1);
        r3=(RadioButton) findViewById(R.id.radio2);
        r4=(RadioButton) findViewById(R.id.radio3);
        t1=(TextView) findViewById(R.id.spider);
        b1=(Button) findViewById(R.id.man);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0 ;
                if (r1.isChecked()){
                    ++score;
                }
                else {
                    --score;
                }
                Intent i=new Intent(twelve.this, thirteen.class);
                startActivity(i);
                finish();
            }
        });
    }
}