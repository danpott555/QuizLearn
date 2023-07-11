package com.smily.quizlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smily.quizlearn.model.FlashCard;
import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ManageScreenActivity extends AppCompatActivity {
    private RecyclerView RcvTA;
    private List<FlashCard> cards;
    private Button btnAddCard;
    private Button btnCreate;
    private EditText edtQuestion;
    private EditText edtAnswer;
    private TextView tvStudySet;
    int setId;
    StudySet studySet;
    private void bindingView() {
        cards = new ArrayList<>();
        RcvTA = findViewById(R.id.RcvTAManage);
        btnAddCard = findViewById(R.id.btnAddCardManage);
        btnCreate = findViewById(R.id.btnCreateManage);
        edtQuestion = findViewById(R.id.NhapEdtManage);
        edtAnswer = findViewById(R.id.MotaEdtManage);
        tvStudySet = findViewById(R.id.tvStudySet);
    }

    private void bindingAction() {
        btnAddCard.setOnClickListener(this::OnClickBtnAddCard);
        btnCreate.setOnClickListener(this::OnClickBtnCreate);
    }

    private void OnClickBtnCreate(View view) {
        InitDatabase.getInstance(this).flashCardDAO().deleteSet(setId);
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
        if (i.hasExtra("setId")) {
            setId = i.getIntExtra("setId", 0);
            studySet=InitDatabase.getInstance(this).studySetDAO().getStudySet(setId);
            tvStudySet.setText(tvStudySet.getText() + " " + studySet.getName());
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
        cards = InitDatabase.getInstance(this).flashCardDAO().getListFlashCard(setId);
        RcvTA.setLayoutManager(new GridLayoutManager(this, 1));
        RcvTA.setAdapter(new AddScreen_Rcv_Adapter(cards, this));
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_screen);
        bindingView();
        receivingIntent();
        bindingAction();
        bindDataToRcvDictionary();
    }


}