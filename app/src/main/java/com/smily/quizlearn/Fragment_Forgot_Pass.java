package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.smily.quizlearn.model.User;
import com.smily.quizlearn.roomdatabase.InitDatabase;
import com.smily.quizlearn.stringhelper.StringHelper;

public class Fragment_Forgot_Pass extends Fragment {
    private EditText email;
    private EditText pass;
    private EditText cfPass;
    private Button btnChange;
    private ImageView iconClose;

    public void bindingView() {
        email = getView().findViewById(R.id.email);
        pass = getView().findViewById(R.id.pass);
        cfPass = getView().findViewById(R.id.cfPass);
        btnChange = getView().findViewById(R.id.btnChange);
        iconClose = getView().findViewById(R.id.iconClose);
    }

    public void bindingAction() {
        btnChange.setOnClickListener(this::changePassword);
        iconClose.setOnClickListener(this::close);
    }

    private void close(View view) {
        getFragmentManager().beginTransaction().remove(Fragment_Forgot_Pass.this).commit();
    }

    private void changePassword(View view) {
        String passUpdate = pass.getText().toString();
        String cfPassUpdate = cfPass.getText().toString();
        if (passUpdate.isEmpty() || cfPassUpdate.isEmpty() || email.getText().toString().isEmpty())
        {
            Toast.makeText(this.getContext(), "Field is empty", Toast.LENGTH_SHORT).show();
        } else {
            User user = InitDatabase.getInstance(this.getContext())
                    .userDAO()
                    .getUserByEmail(email.getText().toString());
            if (user == null) {
                Toast.makeText(this.getContext(), "User doesn't exist", Toast.LENGTH_SHORT).show();
            } else {
                if (!passUpdate.equals(cfPassUpdate)) {
                    Toast.makeText(this.getContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                } else {
                    user.setPassword(new StringHelper().hashPassword(passUpdate));
                    InitDatabase.getInstance(this.getContext())
                            .userDAO()
                            .updateUser(user);
                    Toast.makeText(this.getContext(), "Change Password Successfully", Toast.LENGTH_SHORT).show();
                    getFragmentManager().beginTransaction().remove(Fragment_Forgot_Pass.this).commit();
                }
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forgot_pass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView();
        bindingAction();
    }
}
