package com.smily.quizlearn;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.FlashCard;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.List;

public class ScreenActivity extends AppCompatActivity {

    private AnimatorSet frontAnim;
    private AnimatorSet backAnim;
    private boolean isFront = true;
    TextView front;
    TextView back;
    Button flip;
    Button btnRememberCard;
    Button btnLearningCard;

    private ScrollView homeScrView;
    private LinearLayout homeLinearLayout;
    private RecyclerView rcvQA;
    List<FlashCard> flashCardList;
    int setId;
    public void bindingView(){
        rcvQA=findViewById(R.id.rcvQA);
        homeScrView = findViewById(R.id.homeScrView);
        homeLinearLayout = findViewById(R.id.homeLinearLayout);
        homeScrView.smoothScrollTo(0, homeLinearLayout.getTop());
        btnRememberCard = findViewById(R.id.btnRememberCard);
        btnLearningCard = findViewById(R.id.btnLearningCard);
        front = findViewById(R.id.card_front);
        back = findViewById(R.id.card_back);
        flip = findViewById(R.id.flip_btn);
        float scale = getResources().getDisplayMetrics().density;
        front.setCameraDistance(8000 * scale);
        back.setCameraDistance(8000 * scale);
        Context context = getApplicationContext();
        frontAnim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.front_animator);
        backAnim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.back_animator);
    }
    private void bindDataToRcvDictionary() {
        rcvQA.setLayoutManager(new GridLayoutManager(this,1));
        rcvQA.setAdapter(new Screen_Rcv_Adapter(flashCardList, this));
    }
    public void bindingAction() {
        btnLearningCard.setOnClickListener(this::OnBtnLearningCardClick);
        btnRememberCard.setOnClickListener(this::OnBtnRememberCardClick);
        flip.setOnClickListener(this::OnClick);
    }
    private void receivingIntent() {
        Intent i = getIntent();
        if (i.hasExtra("setId")) {
            flashCardList = new ArrayList<>();
            flashCardList= InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(i.getIntExtra("setId",0));
            setId=i.getIntExtra("setId",0);
        }
    }
    private void OnBtnRememberCardClick(View view) {
        Intent i = new Intent(this, LearnScreenActivity.class);
        i.putExtra("setId", setId);
        this.startActivity(i);

    }

    private void OnBtnLearningCardClick(View view) {
        Intent i = new Intent(this, LearnScreenChooseActivity.class);
        i.putExtra("setId", setId);
        this.startActivity(i);
    }

    private void OnClick(View view) {
        if (isFront) {
            frontAnim.setTarget(front);
            backAnim.setTarget(back);
            frontAnim.start();
            backAnim.start();
            isFront = false;
        } else {
            frontAnim.setTarget(back);
            backAnim.setTarget(front);
            backAnim.start();
            frontAnim.start();
            isFront = true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv);
        bindingView();
        bindingAction();
        receivingIntent();
        bindDataToRcvDictionary();

    }
}