package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.smily.quizlearn.model.FlashCard;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.List;

public class LearnScreenChooseActivity extends AppCompatActivity {
    Button btnContinue;
    fragment_flash_card_learn flash_card_learn;
    List<String> listAnswer;
    Button btnLearnClose;
    int currentPosition = 0;
    int correctAnswer;
    List<FlashCard> flashCardList;
    int setId;
    FlashCard flashCard;
    Button a1;
    Button a2;
    Button a3;
    Button a4;

    public void bindingData() {
        listAnswer = new ArrayList<>();
        flashCard = InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(setId).get(currentPosition);
        for (int i = 0; i < InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(setId).size(); i++) {
            if (i != currentPosition
                    && InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(setId).get(i).getAnswer() != flashCard.getAnswer()
                    && listAnswer.size() < 3) {
                listAnswer.add(InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(setId).get(i).getAnswer());
            }
        }
    }

    public void bindingView() {
        btnContinue = findViewById(R.id.btnContinue);
        btnLearnClose=findViewById(R.id.btnLearnClose);
    }

    private void bindingAction() {
        btnContinue.setOnClickListener(this::OnClick);
        btnLearnClose.setOnClickListener(this::OnBtnLearnClose);
    }

    private void OnBtnLearnClose(View view) {
        finish();
    }

    private void OnClick(View view) {

        if (currentPosition < flashCardList.size() - 1) {
            bindingData();
            flash_card_learn.resetAnswerColors();
            flash_card_learn.enableButton();
            flash_card_learn.setData(flashCard, listAnswer.get(0), listAnswer.get(1), listAnswer.get(2));
            currentPosition++;
            if (currentPosition == flashCardList.size() - 1) {
                btnContinue.setText("Finish");
            }
        }
        if (currentPosition == flashCardList.size() - 1) {
            Intent i= new Intent(LearnScreenChooseActivity.this,QuizResults.class);
            i.putExtra("correct",flash_card_learn.countCorrectAnswer());
            i.putExtra("incorrect",flash_card_learn.countIncorrectAnswer());
            startActivity(i);
        }
    }

    private void receivingIntent() {
        Intent i = getIntent();
        if (i.hasExtra("setId")) {
            flashCardList = new ArrayList<>();
            flashCardList = InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(i.getIntExtra("setId", 0));
            setId = i.getIntExtra("setId", 0);
        }
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof fragment_flash_card_learn) {
            flash_card_learn = (fragment_flash_card_learn) fragment;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        bindingView();
        bindingAction();
        receivingIntent();
    }


}
