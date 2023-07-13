package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.smily.quizlearn.stringhelper.StringHelper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    EditText userName;
    EditText email;
    EditText password;
    EditText rePassword;
    MaterialButton btnSignup;
    MaterialButton btnToLoginScreen;

    Spinner spinnerQuestion;

    EditText edtAnswer;
    SecurityQuestionAdapter securityQuestionAdapter;

    String securityQuestion;

    public void bindingView() {
        userName = findViewById(R.id.username_signup);
        email = findViewById(R.id.email_signup);
        password = findViewById(R.id.password_signup);
        rePassword = findViewById(R.id.rePassWord_signup);
        btnSignup = findViewById(R.id.btnSignup);
        btnToLoginScreen = findViewById(R.id.btnToLoginScreen);
        edtAnswer = findViewById(R.id.edtAnswer);
        spinnerQuestion = findViewById(R.id.spinnerQuestion);
        securityQuestionAdapter = new SecurityQuestionAdapter(this, R.layout.spinner_question_item_selected, getListQuestion());
        spinnerQuestion.setAdapter(securityQuestionAdapter);
        spinnerQuestion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                securityQuestion = securityQuestionAdapter.getItem(i).getQuestion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private List<SecurityQuestion> getListQuestion() {
        List<SecurityQuestion> securityQuestions = new ArrayList<>();
        securityQuestions.add(new SecurityQuestion("Chuyên ngành của bạn là gì?"));
        securityQuestions.add(new SecurityQuestion("Biệt danh của bạn là gì?"));
        securityQuestions.add(new SecurityQuestion("Ngày sinh của bạn?"));
        securityQuestions.add(new SecurityQuestion("Tên thú cưng của bạn?"));
        securityQuestions.add(new SecurityQuestion("Món ăn bạn yêu thích?"));

        return securityQuestions;
    }

    public void bindingAction() {
        btnSignup.setOnClickListener(this::OnClick);
        btnToLoginScreen.setOnClickListener(this::OnBtnToLoginClick);
    }

    private void OnBtnToLoginClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void OnClick(View view) {
        User user = InitDatabase.getInstance(this)
                .userDAO()
                .getUserByEmail(email.getText().toString());
        if (!password.getText().toString().equals("")
                && !userName.getText().toString().equals("")
                && !email.getText().toString().equals("")
                && !rePassword.getText().toString().equals("")
                && !securityQuestion.equals("")
                && !edtAnswer.equals("")) {

            if (!email.getText().toString().matches("^[\\w\\-\\.]+@fpt\\.edu\\.vn$")) {
                Toast.makeText(this, "Email is not in FPT Education", Toast.LENGTH_SHORT).show();
            }

            if (password.getText().toString().equals(rePassword.getText().toString())) {
                if (user == null) {
                    InitDatabase.getInstance(this)
                            .userDAO()
                            .insertUser(new User(email.getText().toString(),
                                    new StringHelper().hashPassword(password.getText().toString()),
                                    userName.getText().toString(),
                                    securityQuestion,
                                    edtAnswer.getText().toString()));
                    Toast.makeText(this, "SignUp successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Email already exist!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Fill all the field, please", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        bindingView();
        bindingAction();
    }
}
