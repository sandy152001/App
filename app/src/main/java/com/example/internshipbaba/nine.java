package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class nine extends AppCompatActivity {
    EditText e1;
    ImageButton ib1,ib2,ib3,ib4;
    TextView t1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nine);
        e1=(EditText) findViewById(R.id.EditTextText7);
        ib1=(ImageButton) findViewById(R.id.imagebutton1);
        ib2=(ImageButton) findViewById(R.id.imagebutton2);
        ib3=(ImageButton) findViewById(R.id.imagebutton3);
        ib4=(ImageButton) findViewById(R.id.imagebutton4);
        t1=(TextView) findViewById(R.id.text16);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(nine.this, eleven.class);
                startActivity(i1);
                finish();
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(nine.this, tenth.class);
                startActivity(i2);
                finish();
            }
        });

        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(nine.this, eight.class);
                startActivity(i3);
                finish();
            }
        });

        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(nine.this, tenth.class);
                startActivity(i4);
                finish();
            }
        });
 }
}