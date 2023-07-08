package com.smily.quizlearn;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScreenActivity extends AppCompatActivity {

    private AnimatorSet frontAnim;
    private AnimatorSet backAnim;
    private boolean isFront = true;
    TextView front;
    TextView back;
    Button flip;
    private RecyclerView rcvQA;
    private List<Screen_Rcv_Card> cards;
    public void bindingView(){
        rcvQA=findViewById(R.id.rcvQA);
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
    private void fakeData() {
        cards = new ArrayList<>();
        cards.add(new Screen_Rcv_Card("PT2=Q1=A service can handle:\n" +
                "A. performfile I/O\n" +
                "B. interact with a content provider\n" +
                "C. network transactions\n" +
                "D. play music", "All"));
        cards.add(new Screen_Rcv_Card("PT2=Q2=A handler can recieve messages from many _____ threads, and update user interface\n" +
                "A. Main Thread\n" +
                "B. Worker thread\n" +
                "C. Ul thread", "A. Main Thread"));
        cards.add(new Screen_Rcv_Card("PT2=Q4=Which statement is not a method of Asyntask?\n" +
                "A. onProgressUpdate\n" +
                "B. doOnBackground\n" +
                "C. onPreExecute\n" +
                "D. onPostExecute", "B. doOnBackground"));
    }
    private void bindDataToRcvDictionary() {
        fakeData();
        rcvQA.setLayoutManager(new GridLayoutManager(this,1));
        rcvQA.setAdapter(new Screen_Rcv_Adapter(cards, this));
    }
    public void bindingAction() {
        flip.setOnClickListener(this::OnClick);
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
        bindDataToRcvDictionary();
    }
}