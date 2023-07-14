package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;
import com.smily.quizlearn.roomdatabase.UserDAO;
import com.smily.quizlearn.roomdatabase.UserDAO_Impl;
import com.smily.quizlearn.stringhelper.StringHelper;

import org.w3c.dom.Text;

public class EditProfile extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText cfPassword;
    TextView question;
    ImageView iconInfo1;
    ImageView iconInfo2;
    TextView email;
    Button btnUpdate;

    ImageView iconBack;
    private User user;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        bindingView();
        bindingAction();
    }

    private void bindingAction() {
        this.setUser();
        btnUpdate.setOnClickListener(this::UpdateClick);
        question.setOnClickListener(this::ChangePasswordClick);
        iconBack.setOnClickListener(this::BackToHome);
    }

    private void BackToHome(View view) {
//        Intent i = new Intent(this, HomeScreenActivity.class);
//        i.putExtra("user", user);
//        startActivity(i);
        finish();
    }

    private void ChangePasswordClick(View view) {
        question.setVisibility(View.INVISIBLE);
        iconInfo1.setVisibility(View.VISIBLE);
        iconInfo2.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);
        cfPassword.setVisibility(View.VISIBLE);
    }

    private void UpdateClick(View view) {
        String usernameUpdate = username.getText().toString();
        if (!usernameUpdate.isEmpty()) {
            User checkUsername = InitDatabase.getInstance(this)
                    .userDAO()
                    .getUserByUsername(usernameUpdate, user.getEmail());
            if (checkUsername != null) {
                Toast.makeText(this, "Username existed", Toast.LENGTH_SHORT).show();
            } else {
                if (question.getVisibility() == View.INVISIBLE) {
                    String passUpdate = password.getText().toString();
                    String cfPassUpdate = cfPassword.getText().toString();
                    if (!passUpdate.equals(cfPassUpdate)) {
                        Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
                    } else {
                        user.setUsername(usernameUpdate);
                        user.setPassword(new StringHelper().hashPassword(passUpdate));
                        InitDatabase.getInstance(this)
                                .userDAO()
                                .updateUser(user);
                        Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(this, LoginActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                } else {
                    user.setUsername(usernameUpdate);
                    InitDatabase.getInstance(this)
                            .userDAO()
                            .updateUser(user);
                    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, LoginActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }

            }
        } else {
            Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
        }
    }

    private void bindingView() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        cfPassword = findViewById(R.id.cfPass);
        email = findViewById(R.id.email);
        btnUpdate = findViewById(R.id.btnUpdate);
        question = findViewById(R.id.question);
        iconInfo1 = findViewById(R.id.passImage);
        iconInfo2 = findViewById(R.id.cfPassImage);
        iconBack = findViewById(R.id.iconBack);
    }

    private void setUser() {
        user = (User) getIntent().getSerializableExtra("user");
        if (user != null) {
            username.setText(user.getUsername());
            email.setText(user.getEmail());
        }
    }
}
