package com.smily.quizlearn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.FlashCard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddScreenActivity extends AppCompatActivity {
    private RecyclerView RcvTA;
    private List<FlashCard> cards;
    private Button btnAddCard;
    private Button btnCreate;
    AddScreen_Rcv_Adapter adapter;
    private void bindingView() {
        cards=new ArrayList<>();
        RcvTA=findViewById(R.id.RcvTA);
        btnAddCard=findViewById(R.id.btnAddCard);
        btnCreate=findViewById(R.id.btnCreate);
    }

    private void bindingAction() {
        btnAddCard.setOnClickListener(this::OnClickBtnAddCard);
        btnCreate.setOnClickListener(this::OnClickBtnCreate);
    }

    private void OnClickBtnCreate(View view) {
        cards = adapter.data;
    }

    private void OnClickBtnAddCard(View view) {
        cards.add(new FlashCard());
        bindDataToRcvDictionary();
    }

    private void bindDataToRcvDictionary() {
        RcvTA.setLayoutManager(new GridLayoutManager(this,1));
        RcvTA.setAdapter(new AddScreen_Rcv_Adapter(cards, this));
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtoclass);
        bindingView();
        bindingAction();
        bindDataToRcvDictionary();
    }




}
