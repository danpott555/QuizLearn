package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {
    TextView userName;
    TextView email;
    TextView password;
    TextView rePassword;
    MaterialButton btnSignup;
    public void bindingView() {
        userName = findViewById(R.id.username_signup);
        email=findViewById(R.id.email_signup);

        password = findViewById(R.id.password_signup);
        rePassword=findViewById(R.id.rePassWord_signup);
        btnSignup = findViewById(R.id.btnSignup);
    }

    public void bindingAction() {
        btnSignup.setOnClickListener(this::OnClick);
    }

    private void OnClick(View view) {
        User user = InitDatabase.getInstance(this)
                .userDAO()
                .getUserByEmail(email.getText().toString());
        if(password.getText().toString()==rePassword.getText().toString())
        {
            if(user != null){
                InitDatabase.getInstance(this)
                        .userDAO()
                        .insertUser(new User(email.getText().toString(),password.getText().toString(),userName.getText().toString()));
                Toast.makeText(this, "SignUp successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Email already exist!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
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
