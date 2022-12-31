package com.example.NewNote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnRegister;
    SharedPreferences sharedPref;
    static String KEY_USERNAME = "username";
    static String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsername = findViewById(R.id.edtNama);
        edtPassword = findViewById(R.id.edtPass);
        btnRegister = findViewById(R.id.btnRegister);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPref.getString(KEY_USERNAME, null) == null) {
                    String username = edtUsername.getText().toString();
                    String password = edtPassword.getText().toString();
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(KEY_USERNAME, username);
                    editor.putString(KEY_PASSWORD, password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "There is an existing account", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
