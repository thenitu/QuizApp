package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView, result;
    Button yes,no;
    String[] questions = {"The black box in a plane is black", "The unicorn is the national animal of Scotland",
                            "Venus is the hottest planet in the solar system","Goldfish have a two second memory",
                            "There are 14 bones in a human foot"};
    boolean[] answers = {false,true,true,false,false};
    int index=0;
    int score=0;
    //hello
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.question);
        result = findViewById(R.id.result);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        textView.setText(questions[0]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index+1 <= questions.length)
                {
                    if(answers[index])
                    {
                        score++;
                    }

                    index++;
                    if(index+1 <= questions.length)
                        textView.setText(questions[index]);
                    result.setText("Your score is: "+score+"/"+questions.length);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Restart the app to play again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index+1 <= questions.length)
                {
                    if(!answers[index])
                    {
                        score++;
                    }

                    index++;
                    if(index+1 <= questions.length)
                        textView.setText(questions[index]);
                    result.setText("Your score is: "+score+"/"+questions.length);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Restart the app to play again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}