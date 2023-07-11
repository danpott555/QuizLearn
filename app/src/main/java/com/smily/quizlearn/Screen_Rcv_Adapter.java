package com.smily.quizlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.FlashCard;

import java.util.List;

public class Screen_Rcv_Adapter extends RecyclerView.Adapter<Screen_Rcv_VH> {
    private List<FlashCard> data;
    private Context context;
    private LayoutInflater inflater;
    public Screen_Rcv_Adapter(List<FlashCard> data,Context context){
        this.data=data;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public Screen_Rcv_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.card,parent,false);
        return new Screen_Rcv_VH(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull Screen_Rcv_VH holder, int position) {
        FlashCard c= data.get(position);
        holder.setProduct(c);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
