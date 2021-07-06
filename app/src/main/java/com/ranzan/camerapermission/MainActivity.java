package com.ranzan.camerapermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private final static int REQ_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permission = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permission, REQ_CODE);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();
        else {
            String[] permission = {Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(MainActivity.this, permission, REQ_CODE);
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permission Granted Toast", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Permission Denied Toast", Toast.LENGTH_SHORT).show();
        }

    }
}