package com.astrocure.astrocurecourses.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astrocure.astrocurecourses.databinding.ItemCourseDetailListBinding;
import com.astrocure.astrocurecourses.ui.CourseDetailActivity;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {
    Context context;

    public CourseListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCourseDetailListBinding binding = ItemCourseDetailListBinding.inflate(LayoutInflater.from(context),parent,false);
        return new CourseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(context, CourseDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        ItemCourseDetailListBinding binding;
        public CourseViewHolder(ItemCourseDetailListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
