package com.smily.quizlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import java.io.File;

public class LoginActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    MaterialButton btnLogin;

    public void bindingView() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbtn);
    }

    public void bindingAction() {
        btnLogin.setOnClickListener(this::OnClick);
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