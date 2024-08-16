package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class tenth extends AppCompatActivity {
    Button b1;
    private TextView textViewResult;
    private boolean isOn = false;
    private String currentInput = "";
    private String operator = "";
    private double firstValue = 0.0;
    private boolean operatorSet = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tenth);
        textViewResult = findViewById(R.id.textViewResult);

        // Setting up buttons
        b1=(Button) findViewById(R.id.back);
        Button btnOn = findViewById(R.id.btnOn);
        Button btnOff = findViewById(R.id.btnOff);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnEqual = findViewById(R.id.btnEqual);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(tenth.this, nine.class);
                startActivity(i);
                finish();
            }
        });

        // Numeric buttons
        Button[] numButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            numButtons[i] = findViewById(resID);
            final int index = i;
            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberClicked(String.valueOf(index));
                }
            });
        }

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOnClicked();
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOffClicked();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearClicked();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteClicked();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("/");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualClicked();
            }
        });
    }

    private void onOnClicked() {
        isOn = true;
        currentInput = "";
        textViewResult.setText("0");
    }

    private void onOffClicked() {
        isOn = false;
        textViewResult.setText("");
        currentInput = "";
        firstValue = 0.0;
        operatorSet = false;
    }

    private void onClearClicked() {
        if (!isOn) return;
        currentInput = "";
        firstValue = 0.0;
        operatorSet = false;
        textViewResult.setText("0");
    }

    private void onDeleteClicked() {
        if (!isOn) return;
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            textViewResult.setText(currentInput);
        }
    }

    private void onNumberClicked(String number) {
        if (!isOn) return;
        currentInput += number;
        textViewResult.setText(currentInput);
    }

    private void onOperatorClicked(String op) {
        if (!isOn) return;
        if (operatorSet) {
            onEqualClicked();
        }
        try {
            firstValue = Double.parseDouble(currentInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }
        operator = op;
        currentInput = "";
        operatorSet = true;
    }

    private void onEqualClicked() {
        if (!isOn || !operatorSet) return;

        double secondValue;
        try {
            secondValue = Double.parseDouble(currentInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = 0.0;
        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        textViewResult.setText(String.valueOf(result));
        currentInput = String.valueOf(result);
        operatorSet = false;
    }
}