package com.smily.quizlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

public class LoginActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    MaterialButton btnLogin;
    MaterialButton btnSignUpInLogin;

    public void bindingView() {
        username = findViewById(R.id.username_signup);
        password = findViewById(R.id.password_signup);
        btnLogin = findViewById(R.id.loginbtn);
        btnSignUpInLogin=findViewById(R.id.btnSignUpInLogin);
    }

    public void bindingAction() {
        btnLogin.setOnClickListener(this::OnClick);
        btnSignUpInLogin.setOnClickListener(this::OnBtnSignUpClick);
    }

    private void OnBtnSignUpClick(View view) {
        startActivity(new Intent(this,SignUpActivity.class));
    }

    private void OnClick(View view) {
        User user = InitDatabase.getInstance(this)
                .userDAO()
                .getUser(username.getText().toString(), password.getText().toString());
        if (user != null) {
            Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, HomeScreenActivity.class);
            i.putExtra("userId", 1);
            startActivity(i);
        } else {
            Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingView();
        bindingAction();
    }
}