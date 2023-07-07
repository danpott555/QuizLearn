package com.smily.quizlearn;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddScreen_Rcv_VH extends RecyclerView.ViewHolder {
    private TextView STT;
    private EditText TN;
    private EditText DN;
    private Context context;
    private void bindingView(){
        STT= itemView.findViewById(R.id.STT);
        TN = itemView.findViewById(R.id.TnEdt);
        DN = itemView.findViewById(R.id.DNEdt);
    }
    private void bindingAction(){
    }
    public AddScreen_Rcv_VH(@NonNull View itemView, Context context) {
        super(itemView);this.context = context;
        bindingView();
        bindingAction();

    }

    public void setProduct(AddScreen_Rcv_CardToAdd c) {
        STT.setText(c.getStt());
        TN.setText(c.getTN());
        DN.setText(c.getDN());
    }
}
