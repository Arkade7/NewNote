package com.example.NewNote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button login;
    Button register;
    SharedPreferences sharedPref;
    static String KEY_USERNAME = "username";
    static String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtNama);
        edtPassword = findViewById(R.id.edtPass);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String username = sharedPref.getString("username", null);
        String password = sharedPref.getString("password", null);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPref.getString(KEY_USERNAME, "username").equals(edtUsername.getText().toString()) && sharedPref.getString(KEY_PASSWORD, "password").equals(edtPassword.getText().toString()))
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else
                {
                    Toast.makeText(LoginActivity.this, "incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}