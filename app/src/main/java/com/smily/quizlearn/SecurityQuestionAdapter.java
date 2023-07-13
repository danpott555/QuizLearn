package com.smily.quizlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SecurityQuestionAdapter extends ArrayAdapter<SecurityQuestion> {
    public SecurityQuestionAdapter(@NonNull Context context, int resource, @NonNull List<SecurityQuestion> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_question_item_selected, parent, false);
        TextView tvSelected = convertView.findViewById(R.id.tvSelected);

        SecurityQuestion securityQuestion = this.getItem(position);
        if (securityQuestion != null){
            tvSelected.setText(securityQuestion.getQuestion());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_question_item, parent, false);
        TextView tvSecurityQuestion = convertView.findViewById(R.id.tvSecurityQuestion);

        SecurityQuestion securityQuestion = this.getItem(position);
        if (securityQuestion != null){
            tvSecurityQuestion.setText(securityQuestion.getQuestion());
        }
        return convertView;
    }
}
