package com.example.internshipbaba;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Method;

public class eight extends AppCompatActivity {
    Button b1, b2;
    Button btnWifiOn, btnWifiOff;
    Button buttonOn;
    Button next;
    TextView t1,t2,t3,t4;
    ImageView iv1,iv2,iv3;
    WifiManager wifiManager;
    BluetoothAdapter bluetoothAdapter;
    Vibrator v1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eight);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        b1 = (Button) findViewById(R.id.onBluetooth);
        b2 = (Button) findViewById(R.id.offBluetooth);
        t1=(TextView) findViewById(R.id.text12);
        t2=(TextView) findViewById(R.id.text13);
        t3=(TextView) findViewById(R.id.text14);
        t4=(TextView) findViewById(R.id.text15);
        iv1=(ImageView) findViewById(R.id.imageview8);
        iv2=(ImageView) findViewById(R.id.imageview9);
        iv3=(ImageView) findViewById(R.id.imageview10);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        btnWifiOn = (Button) findViewById(R.id.btnWifiOn);
        btnWifiOff = (Button) findViewById(R.id.btnWifiOff);
        buttonOn = (Button) findViewById(R.id.button_on);
        next=(Button) findViewById(R.id.nextpg);
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(eight.this, nine.class);
                startActivity(j);
                finish();
            }
        });

        buttonOn.setOnClickListener(v -> {
            if(Build.VERSION.SDK_INT>30){
                v1.vibrate(5000);
                Toast.makeText(this, "Vibrate Till 5 second", Toast.LENGTH_SHORT).show();
            }
            else{
                v1.vibrate(5000);
            }
        });

        // Bluetooth
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
            }
        });


        btnWifiOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q) {
                  Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                  startActivityForResult(panelIntent, 0);
                } else {
                    wifiManager.setWifiEnabled(true);
                }
            }
        });

        btnWifiOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(panelIntent, 0);
                } else {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });
    }
}