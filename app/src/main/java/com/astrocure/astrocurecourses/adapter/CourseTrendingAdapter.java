package com.astrocure.astrocurecourses.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astrocure.astrocurecourses.databinding.ItemTrendingCourseBinding;
import com.astrocure.astrocurecourses.model.CourseModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class CourseTrendingAdapter extends RecyclerView.Adapter<CourseTrendingAdapter.TrendViewHolder> {
    Context context;
    List<CourseModel> courseList;

    public CourseTrendingAdapter(Context context, List<CourseModel> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public TrendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTrendingCourseBinding binding = ItemTrendingCourseBinding.inflate(LayoutInflater.from(context),parent,false);
        return new TrendViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendViewHolder holder, int position) {
        holder.binding.courseName.setText(courseList.get(position).getName());
        Glide.with(context).load(courseList.get(position).getImage())
                .centerCrop()
                .into(holder.binding.courseImg);
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class TrendViewHolder extends RecyclerView.ViewHolder {
        ItemTrendingCourseBinding binding;
        public TrendViewHolder(ItemTrendingCourseBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
