package com.example.gymproject2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {

    EditText exercise1, reps1, exercise2, reps2 ;
    CheckBox check1, check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        exercise1 = findViewById(R.id.exercise1);
        reps1 = findViewById(R.id.reps1);
        check1 = findViewById(R.id.check1);

        exercise2 = findViewById(R.id.exercise2);
        reps2 = findViewById(R.id.reps2);
        check2 = findViewById(R.id.check2);

        Button Back_Button = findViewById(R.id.Back_Button);
        Back_Button.setOnClickListener(v -> // back button is pressed on the exercise page
                finish()
        );


    }
}