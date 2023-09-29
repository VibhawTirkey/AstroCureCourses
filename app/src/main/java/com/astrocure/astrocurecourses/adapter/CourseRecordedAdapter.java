package com.astrocure.astrocurecourses.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astrocure.astrocurecourses.databinding.ItemRecordedListBinding;
import com.astrocure.astrocurecourses.model.CourseModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class CourseRecordedAdapter extends RecyclerView.Adapter<CourseRecordedAdapter.RecordViewHolder> {
    Context context;
    List<CourseModel> courseList;

    public CourseRecordedAdapter(Context context, List<CourseModel> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecordedListBinding binding = ItemRecordedListBinding.inflate(LayoutInflater.from(context),parent,false);
        return new RecordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        holder.binding.title.setText(courseList.get(position).getName());
        Glide.with(context).load(courseList.get(position).getImage())
                .centerCrop()
                .into(holder.binding.image);
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {
        ItemRecordedListBinding binding;
        public RecordViewHolder(ItemRecordedListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
