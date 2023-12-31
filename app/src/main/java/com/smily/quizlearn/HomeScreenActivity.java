package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {
    private RecyclerView rcvMain;
    private List<StudySet> cards;
    private ScrollView homeScrView;
    private LinearLayout homeLinearLayout;
    private TextView tvUsername;
    private TextView tvInsertStudySet;
    private EditText edtSearch;

    private TextView txtLogout;
    private User user;
    private Button btnManage;

    private void bindingView() {
        edtSearch = findViewById(R.id.edtSearch);
        tvInsertStudySet = findViewById(R.id.tvInsertStudySet);
        tvUsername = findViewById(R.id.tvUsername);
        rcvMain = findViewById(R.id.rcvMain);
        homeScrView = findViewById(R.id.homeScrView);
        homeLinearLayout = findViewById(R.id.homeLinearLayout);
        homeScrView.smoothScrollTo(0, homeLinearLayout.getTop());
        txtLogout = findViewById(R.id.txtLogout);
        btnManage = findViewById(R.id.btnManage);
    }

    private void bindingAction() {
        tvInsertStudySet.setOnClickListener(this::OnTvInsertStudySetClick);
        tvUsername.setOnClickListener(this::updateProfileClick);
        txtLogout.setOnClickListener(this::logout);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cards = new ArrayList<>();
                cards = InitDatabase.getInstance(getApplicationContext()).studySetDAO().getListBySearch(charSequence.toString());
                rcvMain.setAdapter(new HomeScreen_Adapter(cards, getApplicationContext()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnManage.setOnClickListener(this::OnBtnManageClick);
    }

    private void OnBtnManageClick(View view) {
        Intent i = new Intent(this, ManageStudySet.class);
        i.putExtra("user", user);
        startActivity(i);
    }

    private void logout(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    private void updateProfileClick(View view) {
        Intent i = new Intent(this, EditProfile.class);
        i.putExtra("user", user);
        startActivity(i);
    }

    private void OnTvInsertStudySetClick(View view) {
        Intent i = new Intent(this, AddScreenActivity.class);
        i.putExtra("user", user);
        startActivity(i);
    }

    private void receivingIntent() {
        Intent i = getIntent();
        if (i.hasExtra("user")) {
            user = (User) i.getSerializableExtra("user");
        }
    }

    private void setData() {
        tvUsername.setText(user.getUsername());
        cards = new ArrayList<>();
        cards = InitDatabase.getInstance(this).studySetDAO().getAll();
    }

    private void bindDataToRcvDictionary() {
        setData();
        rcvMain.setLayoutManager(new GridLayoutManager(this, 1));
        rcvMain.setAdapter(new HomeScreen_Adapter(cards, this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindDataToRcvDictionary();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rcv_screen);
        receivingIntent();
        bindingView();
        bindingAction();
        bindDataToRcvDictionary();
    }

}
