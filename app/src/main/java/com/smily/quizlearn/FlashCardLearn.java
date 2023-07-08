package com.smily.quizlearn;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smily.quizlearn.model.FlashCard;


public class FlashCardLearn extends Fragment {
    private TextView tvQuestion;
    private TextView tvAnswer;
    private AnimatorSet frontAnim;
    private AnimatorSet backAnim;
    private boolean isFront = true;
    Button flip;
    private void bindingView(View v) {
        tvQuestion = v.findViewById(R.id.card_front_learn);
        tvAnswer = v.findViewById(R.id.card_back_learn);
        float scale = getResources().getDisplayMetrics().density;
        tvQuestion.setCameraDistance(8000 * scale);
        tvAnswer.setCameraDistance(8000 * scale);
        Context context = getActivity().getApplicationContext();
        frontAnim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.front_animator);
        backAnim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.back_animator);
        flip = v.findViewById(R.id.flip_btn_learn);
    }
    private void bindingAction() {
        flip.setOnClickListener(this::OnClick);
    }

    private void OnClick(View view) {
        if (isFront) {
            frontAnim.setTarget(tvQuestion);
            backAnim.setTarget(tvAnswer);
            frontAnim.start();
            backAnim.start();
            isFront = false;
        } else {
            frontAnim.setTarget(tvAnswer);
            backAnim.setTarget(tvQuestion);
            backAnim.start();
            frontAnim.start();
            isFront = true;
        }
    }

    public void setData(FlashCard c){
        tvQuestion.setText(c.getQuestion());
        tvAnswer.setText(c.getAnswer());
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView(view);
        bindingAction();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flash_card_remember, container, false);
    }
}