package com.astrocure.astrocurecourses.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.astrocure.astrocurecourses.R;
import com.astrocure.astrocurecourses.adapter.CourseLiveAdapter;
import com.astrocure.astrocurecourses.adapter.CourseProvidedAdapter;
import com.astrocure.astrocurecourses.adapter.CourseRecordedAdapter;
import com.astrocure.astrocurecourses.adapter.CourseTrendingAdapter;
import com.astrocure.astrocurecourses.adapter.TopFacultyAdapter;
import com.astrocure.astrocurecourses.databinding.FragmentCourseBinding;
import com.astrocure.astrocurecourses.model.CourseModel;
import com.astrocure.astrocurecourses.model.FacultyModel;
import com.astrocure.astrocurecourses.model.LiveCourseModel;
import com.astrocure.astrocurecourses.ui.CourseActivity;
import com.astrocure.astrocurecourses.utils.AppConstants;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class CourseFragment extends Fragment {
    FragmentCourseBinding binding;

    public CourseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCourseBinding.inflate(getLayoutInflater());

        Glide.with(requireContext()).load(AppConstants.PROFILE_IMG).centerCrop().into(binding.profileImg);

        setProvidedCourse();
        setRecordedCourse();
        setLiveCourse();
        setTopFaculty();
        setTrendingCourse();

        Intent liveIntent = new Intent(requireContext(),CourseActivity.class);
        liveIntent.putExtra("title","Live Courses");
        binding.liveCourses.setOnClickListener(v -> startActivity(liveIntent));

        Intent recordIntent = new Intent(requireContext(),CourseActivity.class);
        recordIntent.putExtra("title","Recorded Course");
        binding.recordedCourses.setOnClickListener(v -> startActivity(recordIntent));

        return binding.getRoot();
    }

    private void setTrendingCourse() {
        List<CourseModel> courseList = new ArrayList<>();
        courseList.add(new CourseModel("Vedic Astrology", R.drawable.ic_record_course_3));
        courseList.add(new CourseModel("Tarot Astrology", R.drawable.ic_new_course_4));
        courseList.add(new CourseModel("Face Reading", R.drawable.ic_new_course_1));
        CourseTrendingAdapter adapter = new CourseTrendingAdapter(requireContext(), courseList);
        binding.trendingList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.trendingList.setAdapter(adapter);
    }

    private void setTopFaculty() {
        List<FacultyModel> facultyList = new ArrayList<>();
        facultyList.add(new FacultyModel("Harry Potter", "https://upload.wikimedia.org/wikipedia/en/d/d7/Harry_Potter_character_poster.jpg"));
        facultyList.add(new FacultyModel("Hermione Granger", "https://myhero.com/images/guest/g282317/hero105677/image2.jpg"));
        facultyList.add(new FacultyModel("Ron Weasley", "https://images.immediate.co.uk/production/volatile/sites/3/2016/05/108890.jpg?quality=90&resize=882,588"));
        facultyList.add(new FacultyModel("Draco Malfoy", "https://e1.pxfuel.com/desktop-wallpaper/691/388/desktop-wallpaper-draco-malfoy-aesthetic.jpg"));
        facultyList.add(new FacultyModel("Professor Albus Dumbledore", "https://i.insider.com/6179b57a38046100183efe5b?width=700"));
        TopFacultyAdapter adapter = new TopFacultyAdapter(requireContext(), facultyList);
        binding.topFacultyList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.topFacultyList.setAdapter(adapter);
    }

    private void setLiveCourse() {
        List<LiveCourseModel> liveList = new ArrayList<>();
        liveList.add(new LiveCourseModel("Vedic Course", R.drawable.ic_new_course_1, "2h 40min", "14"));
        liveList.add(new LiveCourseModel("Numerology Course", R.drawable.ic_new_course_2, "3h 40min", "14"));
        liveList.add(new LiveCourseModel("Tarot Course", R.drawable.ic_new_course_3, "1h 40min", "14"));
        CourseLiveAdapter adapter = new CourseLiveAdapter(requireContext(), liveList);
        binding.liveCourseList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.liveCourseList.setAdapter(adapter);
    }

    private void setRecordedCourse() {
        List<CourseModel> courseList = new ArrayList<>();
        courseList.add(new CourseModel("Learn astronomy for astrologers", R.drawable.ic_record_course_1));
        courseList.add(new CourseModel("Psychic Development", R.drawable.ic_record_course_2));
        courseList.add(new CourseModel("Become a Tarot Mystic", R.drawable.ic_record_course_3));
        courseList.add(new CourseModel("Tarot Master Course", R.drawable.ic_record_course_4));
        courseList.add(new CourseModel("Learn the cards and share your wisdom", R.drawable.ic_record_course_5));
        courseList.add(new CourseModel("Tarot to improve your life", R.drawable.ic_record_course_6));
        CourseRecordedAdapter adapter = new CourseRecordedAdapter(requireContext(), courseList);
        binding.recordedCourseList.setLayoutManager(new GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false));
        binding.recordedCourseList.setAdapter(adapter);
    }

    private void setProvidedCourse() {
        List<CourseModel> courseList = new ArrayList<>();
        courseList.add(new CourseModel("Numerology", R.drawable.ic_provide_numerology));
        courseList.add(new CourseModel("Tarot Reading", R.drawable.ic_provide_tarot));
        courseList.add(new CourseModel("Face Reading", R.drawable.ic_provide_face_reading));
        courseList.add(new CourseModel("Candle Healing", R.drawable.ic_provide_candle_healing));
        courseList.add(new CourseModel("Vedic", R.drawable.ic_provide_vedic));
        courseList.add(new CourseModel("Vastu Shastra", R.drawable.ic_provide_vastu));
        CourseProvidedAdapter adapter = new CourseProvidedAdapter(requireContext(), courseList);
        binding.courseList.setLayoutManager(new GridLayoutManager(requireContext(), 4, LinearLayoutManager.VERTICAL, false));
        binding.courseList.setAdapter(adapter);
    }
}