package com.smily.quizlearn;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class HomeScreen_VH extends RecyclerView.ViewHolder {
    private TextView nameHocPhan;
    private TextView sLTN;
    private TextView owner;
    private Context context;
    private void bindingView(){
        nameHocPhan= itemView.findViewById(R.id.tvNameHocPhan);
        sLTN = itemView.findViewById(R.id.tvSLTN);
        owner = itemView.findViewById(R.id.tvOwner);
    }
    private void bindingAction(){
    }
    public HomeScreen_VH(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView();
        bindingAction();

    }

    public void setProduct(HomeScreen_Cards c) {
        nameHocPhan.setText(c.getNameHocPhan());
        sLTN.setText(c.getsLTN());
        owner.setText(c.getOwner());
    }
}
