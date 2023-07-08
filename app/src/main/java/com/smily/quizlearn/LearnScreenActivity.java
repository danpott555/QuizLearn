package com.smily.quizlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smily.quizlearn.model.FlashCard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LearnScreenActivity extends AppCompatActivity {

    FlashCardLearn flashCardLearn;
    ImageButton imgBtnBack;
    ImageButton imgBtnNext;

    int current_index = 0;

    List<FlashCard> flashCardList;

    private void bindingView() {
        imgBtnBack = findViewById(R.id.imgBtnBack);
        imgBtnNext = findViewById(R.id.imgBtnNext);
    }

    private void bindingAction() {
        imgBtnBack.setOnClickListener(this::onBtnBackClick);
        imgBtnNext.setOnClickListener(this::onBtnNextClick);
    }

    private void fakeData() {
        flashCardList = new ArrayList<>();
        flashCardList.add(new FlashCard(1,
                "Who is your daddy?",
                "answer",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                false));
        flashCardList.add(new FlashCard(1,
                "Who is your mommy?",
                "answer",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                false));
        flashCardList.add(new FlashCard(1,
                "Who is your brother?",
                "answer",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                false));
    }

    private void onBtnNextClick(View view) {
        if (current_index < flashCardList.size() - 1) {
            flashCardLearn.setData(flashCardList.get(current_index));
            current_index++;
        }

    }

    private void onBtnBackClick(View view) {
        if (current_index > 0) {
            flashCardLearn.setData(flashCardList.get(current_index));
            current_index--;
        }
    }

    private void receivingIntent() {
        Intent i = getIntent();
        if (i.hasExtra("name")) {

        }
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof FlashCardLearn) {
            flashCardLearn = (FlashCardLearn) fragment;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        fakeData();
        bindingView();
        bindingAction();
    }


}