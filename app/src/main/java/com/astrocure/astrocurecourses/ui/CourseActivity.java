package com.astrocure.astrocurecourses.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.astrocure.astrocurecourses.R;
import com.astrocure.astrocurecourses.adapter.CourseListAdapter;
import com.astrocure.astrocurecourses.adapter.FilterExpertiseAdapter;
import com.astrocure.astrocurecourses.databinding.ActivityLiveCourseBinding;
import com.astrocure.astrocurecourses.databinding.DialogBottomCourseFilterBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    ActivityLiveCourseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());

        String title = getIntent().getStringExtra("title");
        if (title!=null){
            binding.title.setText(title);
        }

        List<String> expertiseList = new ArrayList<>();
        expertiseList.add("Tarot");
        expertiseList.add("Vedic");
        expertiseList.add("Vastu");
        expertiseList.add("Numerology");
        expertiseList.add("Psychic");
        binding.filter.setOnClickListener(v -> {
            DialogBottomCourseFilterBinding filterBinding = DialogBottomCourseFilterBinding.inflate(getLayoutInflater());
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CourseActivity.this);
            FilterExpertiseAdapter expertiseAdapter = new FilterExpertiseAdapter(getApplicationContext(), expertiseList);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            filterBinding.expertiseList.setLayoutManager(staggeredGridLayoutManager);
            filterBinding.expertiseList.setAdapter(expertiseAdapter);
            bottomSheetDialog.getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);
            bottomSheetDialog.setContentView(filterBinding.getRoot());
            bottomSheetDialog.show();
        });

        CourseListAdapter adapter = new CourseListAdapter(getApplicationContext());
        binding.contentList.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        binding.contentList.setAdapter(adapter);
    }
}