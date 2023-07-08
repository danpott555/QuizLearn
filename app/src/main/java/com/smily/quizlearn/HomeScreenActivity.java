package com.smily.quizlearn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {
    private RecyclerView rcvMain;
    private List<HomeScreen_Cards> cards;
    private void bindingView() {
        rcvMain=findViewById(R.id.rcvMain);
    }

    private void bindingAction() {

    }
    private void onClick(){

    }

    private void fakeData(){
        cards = new ArrayList<>();
        cards.add(new HomeScreen_Cards("PRN", "300", "Tuan Ngu"));
        cards.add(new HomeScreen_Cards("PRN1", "3001", "Tuan1 Ngu"));
        cards.add(new HomeScreen_Cards("PRN2", "3002", "Tuan2 Ngu"));
        cards.add(new HomeScreen_Cards("PRN3", "3003", "Tuan3 Ngu"));
    }
    private void bindDataToRcvDictionary() {
        fakeData();
        rcvMain.setLayoutManager(new GridLayoutManager(this, 1));
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
