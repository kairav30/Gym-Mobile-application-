package com.example.gymproject2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private void checkcaloriegoal(ProgressBar progressBar){
        if(progressBar.getProgress() >= progressBar.getMax()){ //condition set for the calorie bar
            Toast.makeText(this,"Well done calorie goal reached!", Toast.LENGTH_SHORT).show(); //Toast messaged thats displayed when calories goal is met
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        ImageButton Exercise_Btn = findViewById(R.id.exerciseButton);

        Exercise_Btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExerciseActivity.class); // Exercise btn clicked open exercise activity
            startActivity(intent);
        });
        ImageButton Information_Btn = findViewById(R.id.info_button);

        Information_Btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, information.class); // infomration btn clicked opens information activity
            startActivity(intent);
        });




        EditText HeightInput = findViewById(R.id.HeightInput);
        EditText WeightInput = findViewById(R.id.WeightInput);
        EditText GenderInput = findViewById(R.id.GenderInput);
        EditText CalorieGoalsInput = findViewById(R.id.CalorieGoalsInput);


        ProgressBar progressBar = findViewById(R.id.calorieProgressTracker);
        Button Goalbutton = findViewById(R.id.Goalbutton);

        Button GOAL_10 = findViewById(R.id.goal10);
        Button GOAL_100 = findViewById(R.id.goal100);
        Button GOAL_1000 = findViewById(R.id.goal1000);


        Goalbutton.setOnClickListener(v -> {
            String goalText = CalorieGoalsInput.getText().toString().trim();

            if (!goalText.isEmpty()) { // check if the goal tracker has an input
                int goal = Integer.parseInt(goalText);
                progressBar.setMax(goal);
                progressBar.setProgress(0); // sets progress to 0
            }
        });
        GOAL_10.setOnClickListener(v -> {
                progressBar.incrementProgressBy(10); // increments the progress bar by 10
                checkcaloriegoal(progressBar);
        });
        GOAL_100.setOnClickListener(v -> {
            progressBar.incrementProgressBy(100); // increments the progress bar 100
            checkcaloriegoal(progressBar);
        });
        GOAL_1000.setOnClickListener(v -> {
            progressBar.incrementProgressBy(1000); // increments the progress bar by 1000
            checkcaloriegoal(progressBar);
        });

    }

}