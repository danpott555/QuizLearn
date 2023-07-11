package com.smily.quizlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.List;

public class ManageStudySet extends AppCompatActivity {

    private RecyclerView rcvMainManage;
    private List<StudySet> cards;
    private TextView tvUsernameManage;
    private User user;
    void bindingView(){
        rcvMainManage=findViewById(R.id.rcvMainManage);
        tvUsernameManage=findViewById(R.id.tvUsernameManage);
        tvUsernameManage.setText(user.getUsername());
    }
    void bindingAction(){

    }
    private void bindDataToRcvDictionary() {
        setData();
        rcvMainManage.setLayoutManager(new GridLayoutManager(this, 1));
        rcvMainManage.setAdapter(new ManageStudySetAdapter(cards, this));
    }
    private void setData() {

        cards = new ArrayList<>();
        cards = InitDatabase.getInstance(this).studySetDAO().getListCreated(user.getEmail());
    }
    private void receivingIntent() {
        Intent i = getIntent();
        if (i.hasExtra("user")) {
            user = (User) i.getSerializableExtra("user");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindDataToRcvDictionary();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_study_set);
        receivingIntent();
        bindingView();
        bindingAction();
        bindDataToRcvDictionary();
    }
}