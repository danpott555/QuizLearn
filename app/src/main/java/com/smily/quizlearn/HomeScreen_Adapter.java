package com.smily.quizlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeScreen_Adapter extends RecyclerView.Adapter<HomeScreen_VH> {
    private List<HomeScreen_Cards> data;
    private Context context;
    private LayoutInflater inflater;
    public HomeScreen_Adapter(List<HomeScreen_Cards> data,Context context){
        this.data=data;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public HomeScreen_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.activity_main_screen_card, parent,false);
        return new HomeScreen_VH(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeScreen_VH holder, int position) {
        HomeScreen_Cards c = data.get(position);
        holder.setProduct(c);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
