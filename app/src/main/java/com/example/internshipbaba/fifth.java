package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hbb20.CountryCodePicker;

public class fifth extends AppCompatActivity {
    EditText e1;
    TextView t1,t2,t3;
    ImageView iv1;
    CountryCodePicker ccp;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);
        e1=(EditText) findViewById(R.id.EditTextText3);
        t1=(TextView) findViewById(R.id.text2);
        t2=(TextView) findViewById(R.id.text3);
        t3=(TextView) findViewById(R.id.text4);
        iv1=(ImageView) findViewById(R.id.imageview3);
        ccp=(CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e1);
        b1=(Button) findViewById(R.id.button7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(fifth.this, sixth.class );
                i.putExtra("mobile",ccp.getFullNumberWithPlus().trim());
                startActivity(i);
            }
        });
    }
}