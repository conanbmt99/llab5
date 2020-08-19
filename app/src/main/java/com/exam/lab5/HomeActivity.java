package com.exam.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView text_name,text_email;
    Button btnLOGOUT;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME ="Name";
    private static final String KEY_EMAIL = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        text_name  = findViewById(R.id.text_name);
        text_email = findViewById(R.id.text_email);
        btnLOGOUT = findViewById(R.id.btnLOGOUT);
        sharedPreferences  = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        if(name != null || email != null){
            text_name.setText("Fullname - " +name);
            text_email.setText("Email ID - "+email);
        }
        btnLOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this,"LOGOUT",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}