package com.smily.quizlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    MaterialButton loginbtn;
    public void bindingView(){
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginbtn=findViewById(R.id.loginbtn);
    }
    public void bindingAction(){
        loginbtn.setOnClickListener(this::OnClick);
    }

    private void OnClick(View view) {
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("123456")){
            Toast.makeText(LoginActivity.this,"Login succesfull",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
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