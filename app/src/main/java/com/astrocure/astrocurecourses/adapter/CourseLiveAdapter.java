package com.astrocure.astrocurecourses.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astrocure.astrocurecourses.databinding.ItemLiveCourseListBinding;
import com.astrocure.astrocurecourses.model.LiveCourseModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class CourseLiveAdapter extends RecyclerView.Adapter<CourseLiveAdapter.LiveViewHolder> {
    Context context;
    List<LiveCourseModel> liveList;

    public CourseLiveAdapter(Context context, List<LiveCourseModel> liveList) {
        this.context = context;
        this.liveList = liveList;
    }

    @NonNull
    @Override
    public LiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLiveCourseListBinding binding = ItemLiveCourseListBinding.inflate(LayoutInflater.from(context),parent,false);
        return new LiveViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveViewHolder holder, int position) {
        holder.binding.courseName.setText(liveList.get(position).getCourseName());
        holder.binding.courseDetail.setText(liveList.get(position).getDuration()+" • "+ liveList.get(position).getLessonCount()+" lesson");
        Glide.with(context).load(liveList.get(position).getCourseImg())
                .centerCrop()
                .into(holder.binding.courseImg);
    }

    @Override
    public int getItemCount() {
        return liveList.size();
    }

    public class LiveViewHolder extends RecyclerView.ViewHolder {
        ItemLiveCourseListBinding binding;
        public LiveViewHolder(ItemLiveCourseListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
