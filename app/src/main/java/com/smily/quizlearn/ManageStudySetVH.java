package com.smily.quizlearn;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.roomdatabase.InitDatabase;

public class ManageStudySetVH extends RecyclerView.ViewHolder {
    private TextView nameHocPhan;
    private TextView sLTN;
    private TextView owner;
    private Context context;
    int setId;
    private void bindingView(){
        nameHocPhan= itemView.findViewById(R.id.tvNameHocPhan);
        sLTN = itemView.findViewById(R.id.tvSLTN);
        owner = itemView.findViewById(R.id.tvOwner);
    }
    private void bindingAction(){
        itemView.setOnClickListener(this::onItemClick);
    }

    private void onItemClick(View view) {
        Intent i = new Intent(context, ManageScreenActivity.class);
        i.putExtra("setId", setId);
        context.startActivity(i);
    }

    public ManageStudySetVH(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView();
        bindingAction();

    }

    public void setProduct(StudySet c) {
        setId=c.getId();
        nameHocPhan.setText(c.getName());
        sLTN.setText(Integer.toString(InitDatabase.getInstance(context).flashCardDAO().getListFlashCard(c.getId()).size()) + " thuật ngữ");
        owner.setText(c.getCreateBy());
    }
}
