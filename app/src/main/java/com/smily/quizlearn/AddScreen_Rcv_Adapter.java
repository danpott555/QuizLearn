package com.smily.quizlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddScreen_Rcv_Adapter extends RecyclerView.Adapter<AddScreen_Rcv_VH> {
    public List<AddScreen_Rcv_CardToAdd> data;
    private Context context;
    private LayoutInflater inflater;
    public AddScreen_Rcv_Adapter(List<AddScreen_Rcv_CardToAdd> data,Context context){
        this.data=data;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public AddScreen_Rcv_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.card,parent,false);
        return new AddScreen_Rcv_VH(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull AddScreen_Rcv_VH holder, int position) {
        AddScreen_Rcv_CardToAdd c= data.get(position);
        holder.setProduct(c);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
