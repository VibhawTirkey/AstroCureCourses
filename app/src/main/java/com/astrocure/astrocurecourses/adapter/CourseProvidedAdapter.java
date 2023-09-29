package com.astrocure.astrocurecourses.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astrocure.astrocurecourses.databinding.ItemCourseListBinding;
import com.astrocure.astrocurecourses.model.CourseModel;
import com.astrocure.astrocurecourses.ui.CourseActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class CourseProvidedAdapter extends RecyclerView.Adapter<CourseProvidedAdapter.CourseViewHolder> {
    Context context;
    List<CourseModel> courseList;

    public CourseProvidedAdapter(Context context, List<CourseModel> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCourseListBinding binding = ItemCourseListBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CourseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.binding.courseName.setText(courseList.get(position).getName());
        Glide.with(context).load(courseList.get(position).getImage())
                .centerCrop()
                .into(holder.binding.courseImg);
        int pos = position;
        Intent intent = new Intent(context, CourseActivity.class);
        holder.binding.getRoot().setOnClickListener(v -> {
            switch (courseList.get(pos).getName()) {
                case "Numerology":
                    intent.putExtra("title", "Numerology Astrology");
                    context.startActivity(intent);
                    break;
                case "Tarot Reading":
                    intent.putExtra("title", "Tarot Astrology");
                    context.startActivity(intent);
                    break;
                case "Face Reading":
                    intent.putExtra("title", "Face Reading Astrology");
                    context.startActivity(intent);
                    break;
                case "Candle Healing":
                    intent.putExtra("title", "Candle Healing Astrology");
                    context.startActivity(intent);
                    break;
                case "Vedic":
                    intent.putExtra("title", "Vedic Astrology");
                    context.startActivity(intent);
                    break;
                case "Vastu Shastra":
                    intent.putExtra("title", "Vastu Shastra Astrology");
                    context.startActivity(intent);
                    break;
            }
        });

    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        ItemCourseListBinding binding;

        public CourseViewHolder(ItemCourseListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
