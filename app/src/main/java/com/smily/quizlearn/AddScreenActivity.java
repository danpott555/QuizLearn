package com.smily.quizlearn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddScreenActivity extends AppCompatActivity {
    private RecyclerView RcvTA;
    private List<AddScreen_Rcv_CardToAdd> cards;
    private void bindingAction() {
        RcvTA=findViewById(R.id.RcvTA);
    }

    private void bindingView() {

    }
    private void bindDataToRcvDictionary() {
        RcvTA.setAdapter(new AddScreen_Rcv_Adapter(cards, this));
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
