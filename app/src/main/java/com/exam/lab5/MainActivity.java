package com.exam.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name, et_email;
    Button btnOK;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME ="Name";
    private static final String KEY_EMAIL = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        btnOK = findViewById(R.id.btnOK);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME ,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME,null);
        if(name != null){
            Intent intent   = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,et_name.getText().toString());
                editor.putString(KEY_EMAIL,et_email.getText().toString());
                editor.apply();
                Intent intent =     new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Co VAN de thuong...",Toast.LENGTH_LONG).show();
            }
        });
    }
}