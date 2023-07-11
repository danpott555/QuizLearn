package com.smily.quizlearn;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.FlashCard;

public class AddScreen_Rcv_VH extends RecyclerView.ViewHolder {
    private TextView STT;
    private EditText TN;
    private EditText DN;
    private Context context;

    private EditText edtQuestion;
    private EditText edtAnswer;
    AddScreen_Rcv_Adapter adapter;
    int currentIndex = 1;
    Button btnDelete;

    private void bindingView() {
        STT = itemView.findViewById(R.id.STT);
        TN = itemView.findViewById(R.id.TnEdt);
        DN = itemView.findViewById(R.id.DNEdt);
        edtQuestion = itemView.findViewById(R.id.NhapEdt);
        edtAnswer = itemView.findViewById(R.id.MotaEdt);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }

    private void bindingAction() {
        btnDelete.setOnClickListener(this::OnBtnDeleteClick);
    }

    private void OnBtnDeleteClick(View view) {
        adapter.data.remove(getAdapterPosition());
        adapter.notifyItemRemoved(getAdapterPosition());
    }

    public AddScreen_Rcv_VH linkAdapter(AddScreen_Rcv_Adapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public AddScreen_Rcv_VH(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView();
        bindingAction();

    }

    public void setProduct(FlashCard c) {

        STT.setText(Integer.toString(getAdapterPosition() + 1));
        DN.setText(c.getAnswer());
        TN.setText(c.getQuestion());
    }

}
