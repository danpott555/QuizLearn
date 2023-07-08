package com.smily.quizlearn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {
    private RecyclerView rcvMain;
    private List<HomeScreen_Cards> cards;
    private void bindingAction() {
        rcvMain=findViewById(R.id.rcvMain);
    }

    private void bindingView() {

    }
    private void bindDataToRcvDictionary() {
        rcvMain.setAdapter(new HomeScreen_Adapter(cards, this));
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rcv_screen);
        bindingView();
        bindingAction();
        bindDataToRcvDictionary();
    }

}
