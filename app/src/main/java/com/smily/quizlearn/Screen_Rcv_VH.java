package com.smily.quizlearn;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.FlashCard;

public class Screen_Rcv_VH extends RecyclerView.ViewHolder {
    private TextView question;
    private TextView answer;
    private Context context;
    private void bindingView(){
        answer = itemView.findViewById(R.id.answer);
        question = itemView.findViewById(R.id.question);
    }
    private void bindingAction(){
    }
    public Screen_Rcv_VH(@NonNull View itemView, Context context) {
        super(itemView);this.context = context;
        bindingView();
        bindingAction();

    }

    public void setProduct(FlashCard c) {

        answer.setText(c.getAnswer());
        question.setText(c.getQuestion());
    }

}
