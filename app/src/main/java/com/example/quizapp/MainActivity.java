package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button yes;
    Button no;
    TextView textView;
    private static int i;
    private static int marks;
    String[] questions = {"Is java an Object Oriented Programming Language?","Is java and javascript same?", "Is java the first Object Oriented language?",
            "Is java developed by Oracle?","can java be used to develop Android Application?"};
    String[] answers = {"yes","no","no","no","yes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        textView = findViewById(R.id.textView);
        display(i);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    display(i);
                    if (i == questions.length){
                        Toast.makeText(MainActivity.this, "Question Reset", Toast.LENGTH_SHORT).show();
                        marks = 0;
                        i = 0;
                    }
                    else{
                        if (answers[i].equals("yes")){
                            marks++;
                        }
                        i++;
                    }

                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    display(i);
                    if (i == questions.length){
                        Toast.makeText(MainActivity.this, "Question Reset", Toast.LENGTH_SHORT).show();
                        marks = 0;
                        i = 0;
                    }
                    if (answers[i].equals("no")){
                        marks++;
                    }
                    i++;
                }
            });
    }

    private void display(int i) {
        if (i < questions.length){
            textView.setText(questions[i]);
        }
        else{
            textView.setText("You got "+marks);
        }
    }

}