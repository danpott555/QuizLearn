package com.smily.quizlearn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment_flash_card_learn extends Fragment {


    Button a1;
    Button a2;
    Button a3;
    Button a4;
    int current_index = 0;
    public void bindingView(View v){
        a1=v.findViewById(R.id.answer_1);
        a2=v.findViewById(R.id.answer_2);
        a3=v.findViewById(R.id.answer_3);
        a4=v.findViewById(R.id.answer_4);
    }
    public void bindingAction(View v){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flash_card_learn, container, false);
    }
}