package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

public class forth extends AppCompatActivity {
    EditText e1,e2;
    ProgressBar p1;
    ImageView iv;
    Button b1,b2;
    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forth);
       e1=(EditText) findViewById(R.id.EditTextText);
       e2=(EditText) findViewById(R.id.EditTextText2);
       iv=(ImageView) findViewById(R.id.imageview1);
       p1=(ProgressBar) findViewById(R.id.progressBar1);
       firebaseAuth=FirebaseAuth.getInstance();
       b1=(Button) findViewById(R.id.button6);
        b2=(Button) findViewById(R.id.bad);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String s1=e1.getText().toString().trim();
               String s2=e2.getText().toString();
               if (s1.isEmpty()){
                   e1.setError("fill Email");
                   return;
               }
               else {
                   if (s2.isEmpty()){
                       e2.setError("fill password");
                       return;
                   }
                   else {
                       p1.setVisibility(View.VISIBLE);
                       firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                              if (task.isSuccessful()){
                                  p1.setVisibility(View.INVISIBLE);
                                  Toast.makeText(forth.this, "database updated", Toast.LENGTH_SHORT).show();
                                  Intent j=new Intent(forth.this, second.class);
                                  startActivity(j);
                                  finish();
                              }
                              else {
                                  p1.setVisibility(View.INVISIBLE);
                                  Toast.makeText(forth.this, "database nhi hua", Toast.LENGTH_SHORT).show();
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
               Intent e1= new Intent(forth.this, second.class);
               startActivity(e1);
               finish();
           }
       });

    }
}