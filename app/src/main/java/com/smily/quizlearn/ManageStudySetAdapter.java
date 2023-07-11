package com.smily.quizlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smily.quizlearn.model.StudySet;

import java.util.List;

public class ManageStudySetAdapter extends RecyclerView.Adapter<ManageStudySetVH>{
    private List<StudySet> data;
    private Context context;
    private LayoutInflater inflater;
    public ManageStudySetAdapter(List<StudySet> data,Context context){
        this.data=data;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ManageStudySetVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.activity_main_screen_card, parent,false);
        return new ManageStudySetVH(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull ManageStudySetVH holder, int position) {
        StudySet c = data.get(position);
        holder.setProduct(c);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
