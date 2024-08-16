package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class seven extends AppCompatActivity {
    ImageView iv;
    EditText e1,e2;
    ProgressBar p1;
    Button b1,b2;
    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seven);
        iv=(ImageView) findViewById(R.id.imageview2);
        e1=(EditText) findViewById(R.id.EditTextText5);
        e2=(EditText) findViewById(R.id.EditTextText6);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1=(Button) findViewById(R.id.button9);
        b2=(Button) findViewById(R.id.bay);
        p1=(ProgressBar) findViewById(R.id.progressBar2);
        firebaseAuth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("fill email");
                    return;
                }
                else {
                    if (s2.isEmpty()){
                        e2.setError("fill password");
                        return;
                    }
                    else {
                        p1.setVisibility(View.VISIBLE);
                        firebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(seven.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(seven.this, nine.class);
                                    startActivity(i);
                                    finish();
                                }
                                else {
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(seven.this, "Database nhi hua", Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(seven.this, forth.class);
                                    startActivity(i);
                                    finish();
                                }
                            }
                        });
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j =new Intent(seven.this, second.class);
                startActivity(j);
                finish();
            }
        });
    }
}