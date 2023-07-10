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
import com.smily.quizlearn.roomdatabase.InitDatabase;

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
        if (i.hasExtra("setId")) {
            flashCardList = new ArrayList<>();
            flashCardList= InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(i.getIntExtra("setId",0));
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
        bindingView();
        bindingAction();
        receivingIntent();
    }


}