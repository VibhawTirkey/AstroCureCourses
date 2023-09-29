package com.astrocure.astrocurecourses.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.astrocure.astrocurecourses.R;
import com.astrocure.astrocurecourses.databinding.ActivityCourseDetailBinding;

public class CourseDetailActivity extends AppCompatActivity {
    ActivityCourseDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCourseDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}