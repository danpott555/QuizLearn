package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_profile extends Fragment {
    private TextView txtProfile;
    private TextView txtLogout;

    private String email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindingView();
        bindingAction();
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    private void bindingView() {
        txtLogout = getView().findViewById(R.id.txtLogout);
        txtProfile = getView().findViewById(R.id.txtEditProfile);
    }

    private void bindingAction() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            email = bundle.getString("email");
        }
        Intent intent = new Intent(getActivity(), EditProfile.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}
