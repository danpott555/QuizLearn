package com.smily.quizlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    MaterialButton btnLogin;
    MaterialButton btnSignUpInLogin;

    TextView forgotPass;

    public void bindingView() {
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbtn);
        btnSignUpInLogin=findViewById(R.id.btnSignUpInLogin);
        forgotPass = findViewById(R.id.forgotpass);
    }

    public void bindingAction() {
        btnLogin.setOnClickListener(this::OnClick);
        btnSignUpInLogin.setOnClickListener(this::OnBtnSignUpClick);
        forgotPass.setOnClickListener(this::forgotPass);
    }

    private void forgotPass(View view) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.frgForgotPass, Fragment_Forgot_Pass.class, null)
                .commit();
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
            i.putExtra("user", user);
            startActivity(i);
        } else {
            Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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