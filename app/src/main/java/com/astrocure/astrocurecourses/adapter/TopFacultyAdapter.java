package com.astrocure.astrocurecourses.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astrocure.astrocurecourses.databinding.ItemTopFacultyBinding;
import com.astrocure.astrocurecourses.model.FacultyModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class TopFacultyAdapter extends RecyclerView.Adapter<TopFacultyAdapter.FacultyViewHolder> {
    Context context;
    List<FacultyModel> facultyList;

    public TopFacultyAdapter(Context context, List<FacultyModel> facultyList) {
        this.context = context;
        this.facultyList = facultyList;
    }

    @NonNull
    @Override
    public FacultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTopFacultyBinding binding = ItemTopFacultyBinding.inflate(LayoutInflater.from(context),parent,false);
        return new FacultyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyViewHolder holder, int position) {
        holder.binding.name.setText(facultyList.get(position).getName());
        Glide.with(context).load(facultyList.get(position).getImageUrl())
                .centerCrop()
                .into(holder.binding.facultyImg);
    }

    @Override
    public int getItemCount() {
        return facultyList.size();
    }

    public class FacultyViewHolder extends RecyclerView.ViewHolder {
        ItemTopFacultyBinding binding;
        public FacultyViewHolder(ItemTopFacultyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
