package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.FlashCard;
import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class AddScreenActivity extends AppCompatActivity {
    private RecyclerView RcvTA;
    private List<FlashCard> cards;
    private Button btnAddCard;
    private Button btnCreate;
    private EditText edtQuestion;
    private EditText edtAnswer;
    private TextView edtNameStudySet;
    private User user;
    AddScreen_Rcv_Adapter adapter;

    private void bindingView() {
        cards = new ArrayList<>();
        RcvTA = findViewById(R.id.RcvTA);
        btnAddCard = findViewById(R.id.btnAddCard);
        btnCreate = findViewById(R.id.btnCreate);
        edtQuestion = findViewById(R.id.NhapEdt);
        edtAnswer = findViewById(R.id.MotaEdt);
        edtNameStudySet = findViewById(R.id.edtNameStudyset);
    }

    private void bindingAction() {
        btnAddCard.setOnClickListener(this::OnClickBtnAddCard);
        btnCreate.setOnClickListener(this::OnClickBtnCreate);
    }

    private void OnClickBtnCreate(View view) {
        InitDatabase.getInstance(this)
                .studySetDAO()
                .insertStudySet(new StudySet(edtNameStudySet
                        .getText().toString(),
                        user.getEmail(),
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime(),
                        ""));
        List<StudySet> studySets = InitDatabase
                .getInstance(this)
                .studySetDAO()
                .getAll();
        StudySet studySet=studySets.get(studySets.size()-1);
        for (FlashCard c : cards) {
            c.setSetId(studySet.getId());
            InitDatabase.getInstance(this)
                    .flashCardDAO()
                    .insertFlashCard(c);
        }
        finish();
    }

    private void receivingIntent() {
        Intent i = getIntent();
        if (i.hasExtra("user")) {
            user = (User) i.getSerializableExtra("user");
        }
    }

    private void OnClickBtnAddCard(View view) {
        String question = edtQuestion.getText().toString().trim();
        String answer = edtAnswer.getText().toString().trim();
        FlashCard newCard = new FlashCard(question, answer);
        newCard.setAnswer(answer);
        newCard.setQuestion(question);
        cards.add(newCard);
        bindDataToRcvDictionary();
        edtQuestion.setText("");
        edtAnswer.setText("");
    }

    private void bindDataToRcvDictionary() {
        RcvTA.setLayoutManager(new GridLayoutManager(this, 1));
        RcvTA.setAdapter(new AddScreen_Rcv_Adapter(cards, this));
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtoclass);
        receivingIntent();
        bindingView();
        bindingAction();
        bindDataToRcvDictionary();
    }


}
