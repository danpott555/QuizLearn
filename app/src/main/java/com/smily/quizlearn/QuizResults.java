package com.smily.quizlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    Button btnReturn;
    TextView correctAnswer;
    TextView incorrectAnswer;

    private void bindingView(){
        btnReturn=findViewById(R.id.returnToLearning);
        correctAnswer=findViewById(R.id.correctAnswer);
        incorrectAnswer=findViewById(R.id.IncorrectAnswer);


    }
    private void bindingAction(){
        int GetCorrectAnswers=getIntent().getIntExtra("correct",0);
        int GetIncorrectAnswers=getIntent().getIntExtra("incorrect",0);
        correctAnswer.setText(String.valueOf(GetCorrectAnswers));
        incorrectAnswer.setText(String.valueOf(GetIncorrectAnswers));
        btnReturn.setOnClickListener(this::OnClick);
    }

    private void OnClick(View view) {
        startActivity(new Intent(QuizResults.this,LearnScreenChooseActivity.class));
        finish();
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(QuizResults.this,LearnScreenChooseActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        bindingView();
        bindingAction();
    }
}