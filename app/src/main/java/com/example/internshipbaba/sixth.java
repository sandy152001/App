package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class sixth extends AppCompatActivity {
   EditText e1;
   ImageView iv1;
   TextView t1,t2,t3,t4;
   Button b1;
   String phone;
   String otp;
   FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixth);
        phone=getIntent().getStringExtra("mobile").toString();
        e1=(EditText) findViewById(R.id.EditTextText4);
        iv1=(ImageView) findViewById(R.id.imageview4);
        t1=(TextView) findViewById(R.id.text5);
        t2=(TextView) findViewById(R.id.text6);
        t3=(TextView) findViewById(R.id.text7);
        t4=(TextView) findViewById(R.id.text8);
        b1=(Button) findViewById(R.id.button8);
        firebaseAuth=FirebaseAuth.getInstance();
        gentop();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,s1);
                signInWithPhoneAuthCredential(credential);
            }
        });
    }
    private void gentop(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken){
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                     signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(sixth.this, "otp mismatch", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   Toast.makeText(sixth.this, "database updated", Toast.LENGTH_SHORT).show();
                   Intent j=new Intent(sixth.this, nine.class);
                   startActivity(j);
                   finish();
               }
               else {
                   Toast.makeText(sixth.this, "Nhi Hua Gaandu", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}