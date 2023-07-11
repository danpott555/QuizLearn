package com.smily.quizlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_avatar extends Fragment {

    private ImageView avatar1;
    private ImageView avatar2;
    private ImageView avatar3;
    private ImageView avatar4;
    private ImageView avatar5;
    private ImageView avatar6;

    private void bindingView() {
        avatar1 = getView().findViewById(R.id.avatar1);
        avatar2 = getView().findViewById(R.id.avatar2);
        avatar3 = getView().findViewById(R.id.avatar3);
        avatar4 = getView().findViewById(R.id.avatar4);
        avatar5 = getView().findViewById(R.id.avatar5);
        avatar6 = getView().findViewById(R.id.avatar6);

    }

    private void bindingAction() {
        avatar1.setOnClickListener(this::UpdateAvatar);
        avatar2.setOnClickListener(this::UpdateAvatar);
        avatar3.setOnClickListener(this::UpdateAvatar);
        avatar4.setOnClickListener(this::UpdateAvatar);
        avatar5.setOnClickListener(this::UpdateAvatar);
        avatar6.setOnClickListener(this::UpdateAvatar);

    }

    private void UpdateAvatar(View view) {
        Intent intent = new Intent(getActivity(), EditProfile.class);
        intent.putExtra("avatar", view.getDrawableState());
        startActivity(intent);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindingView();
        bindingAction();
        return inflater.inflate(R.layout.fragment_avatar, container, false);
    }
}
