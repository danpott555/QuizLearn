package com.smily.quizlearn;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smily.quizlearn.model.FlashCard;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class fragment_flash_card_learn extends Fragment {

    TextView questions;
    Button a1;
    Button a2;
    Button a3;
    Button a4;
    QuestionList questionList;
    List<String> listAnswer;
    String correctAnswer;
    int countCorrectAnswer;
    int countIncorrectAnswer;
    public void bindingView(View v){
        a1=v.findViewById(R.id.answer_1);
        a2=v.findViewById(R.id.answer_2);
        a3=v.findViewById(R.id.answer_3);
        a4=v.findViewById(R.id.answer_4);
        questions=v.findViewById(R.id.question_learn);
    }
    public void bindingAction(){
        a1.setOnClickListener(this::OnClick);
        a2.setOnClickListener(this::OnClick);
        a3.setOnClickListener(this::OnClick);
        a4.setOnClickListener(this::OnClick);
    }

    private void OnClick(View view) {
        if(view instanceof Button){
            Button clickedButton=(Button) view;
            String buttonText=clickedButton.getText().toString();
            if(buttonText.equals(correctAnswer)){
                RevealAnswer();
                countCorrectAnswer();
                disableButton();
            }else{
                WrongAnswer(clickedButton);
                countIncorrectAnswer();
                RevealAnswer();
                disableButton();
            }
        }
    }
    void disableButton(){
        a1.setEnabled(false);
        a2.setEnabled(false);
        a3.setEnabled(false);
        a4.setEnabled(false);
    }
    public void enableButton(){
        a1.setEnabled(true);
        a2.setEnabled(true);
        a3.setEnabled(true);
        a4.setEnabled(true);
    }


    public void setData(FlashCard c, String answer1, String answer2, String answer3){
        correctAnswer=c.getAnswer();
        questions.setText(c.getQuestion());
        Random random= new Random();
        String[] strings={c.getAnswer(),answer1,answer2,answer3};
        for (int i = 0; i < strings.length; i++) {
            int randomIndex = random.nextInt(strings.length);
            String temp = strings[i];
            strings[i] = strings[randomIndex];
            strings[randomIndex] = temp;
        }
        a1.setText(strings[0]);
        a2.setText(strings[1]);
        a3.setText(strings[2]);
        a4.setText(strings[3]);
    }
    private void RevealAnswer(){
        if(a1.getText().toString().equals(correctAnswer)){
            a1.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
            a1.setTextColor(Color.WHITE);
        }else if(a2.getText().toString().equals(correctAnswer)){
            a2.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
            a2.setTextColor(Color.WHITE);
        }else if(a3.getText().toString().equals(correctAnswer)){
            a3.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
            a3.setTextColor(Color.WHITE);
        }else if(a4.getText().toString().equals(correctAnswer)){
            a4.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
            a4.setTextColor(Color.WHITE);
        }
    }
    private void WrongAnswer(Button a){
        a.setBackgroundColor(getResources().getColor(R.color.InCorrectAnswer));
    }
    public void resetAnswerColors() {
        a1.setBackgroundColor(R.style.btnStyle);
        a2.setBackgroundColor(R.style.btnStyle);
        a3.setBackgroundColor(R.style.btnStyle);
        a4.setBackgroundColor(R.style.btnStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flash_card_learn, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView(view);
        bindingAction();
    }

    public int countCorrectAnswer() {
        return countCorrectAnswer++;
    }

    public int countIncorrectAnswer() {
        return countIncorrectAnswer++;
    }
}