
package com.example.gymproject2;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText register_username, register_email, register_password, register_confirm_password;
    Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_username = (EditText) findViewById(R.id.regUsername);
        register_email = (EditText) findViewById(R.id.regEmail);
        register_password = (EditText) findViewById(R.id.regPassword);
        register_confirm_password = (EditText) findViewById(R.id.regConfirmPassword);
        register_button = (Button) findViewById(R.id.registerBtn);

        final SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = register_username.getText().toString().trim(); // def username as a variable
                String email = register_email.getText().toString().trim(); // def email as a variable
                String password = register_password.getText().toString(); // def password as a variable
                String confirmPassword = register_confirm_password.getText().toString(); // def confrimPassword as variable

                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show(); // Toast message that is displayed when username field is not filled out
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Passwords are not the same!", Toast.LENGTH_SHORT).show(); // Toast message that is displayed when password and confirm passwords do not match
                    return;
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Username", username);
                editor.putString("Email Address", email);
                editor.putString("Password", password);
                editor.putString("confirm password", confirmPassword);
                editor.apply();

                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show(); // Toast message displayed when registration was successful
                finish(); // go back to LoginActivity
            }
        });
    }
}