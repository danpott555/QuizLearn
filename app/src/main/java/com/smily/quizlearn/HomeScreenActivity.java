package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {
    private RecyclerView rcvMain;
    private List<HomeScreen_Cards> cards;
    private TextView txtProfile;
    private User user;

    private void bindingView() {
        rcvMain = findViewById(R.id.rcvMain);
        txtProfile = findViewById(R.id.txtProfile);
    }

    private void bindingAction() {
        txtProfile.setText(user.getUsername());
        txtProfile.setOnClickListener(this::profileClick);
    }

    private void profileClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("email", user.getEmail());

        Fragment_profile fragment = new Fragment_profile();
        fragment.setArguments(bundle);
        fragment.setEmail(user.getEmail());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContentUpdate, fragment)
                .commit();
    }

    private void onClick() {

    }

    private void fakeData() {
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

    private void setUser() {
        Intent intent = new Intent();
        String emailMeassage = intent.getStringExtra("email");
        user = InitDatabase.getInstance(this)
                .userDAO()
                .getUserByEmail(emailMeassage);
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
