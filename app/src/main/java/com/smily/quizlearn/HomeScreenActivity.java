package com.smily.quizlearn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {
    private RecyclerView rcvMain;
    private List<StudySet> cards;
    private void bindingView() {
        rcvMain=findViewById(R.id.rcvMain);
    }

    private void bindingAction() {

    }
    private void onClick(){

    }

    private void fakeData(){
        cards = new ArrayList<>();
        cards= InitDatabase.getInstance(this).studySetDAO().getAll();
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
