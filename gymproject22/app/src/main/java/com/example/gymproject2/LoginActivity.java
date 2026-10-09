package com.example.gymproject2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button loginBtn, goToRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // ensure this layout exists

        loginUsername = (EditText) findViewById(R.id.loginUsername); // links xml to java using id
        loginPassword = (EditText) findViewById(R.id.loginPassword); // links xml to java using id
        loginBtn = (Button) findViewById(R.id.loginBtn); // links xml to java using id
        goToRegisterBtn = (Button) findViewById(R.id.goToRegisterBtn); // links xml to java using id

        final SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String savedUsername = sharedPreferences.getString("Username", "");
                String savedPassword = sharedPreferences.getString("Password", "");

                String inputUsername = loginUsername.getText().toString().trim();
                String inputPassword = loginPassword.getText().toString().trim();

                if (inputUsername.equals(savedUsername) && inputPassword.equals(savedPassword)) { // If statement for successful login

                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show(); // Toast message displayed when login was successful
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();


                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show(); // Toast message displayed when inavlid username or password is used
                }
            }
        });

        goToRegisterBtn.setOnClickListener(new View.OnClickListener() { // on click listener for register button on login page
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class); // changes the state of the activity
                startActivity(intent);

            }
        });
    }
}