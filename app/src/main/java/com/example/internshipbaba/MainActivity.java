package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1;
    TextView t1,t2,t3,t4;
    ImageView iv1,iv2,iv3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.text1);
        t2=(TextView) findViewById(R.id.text9);
        t3=(TextView) findViewById(R.id.text10);
        t4=(TextView) findViewById(R.id.text11);
        iv1=(ImageView) findViewById(R.id.imageview5);
        iv2=(ImageView) findViewById(R.id.imageview6);
        iv3=(ImageView) findViewById(R.id.imageview7);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, second.class);
                startActivity(i);
                finish();
            }
        });
    }
}