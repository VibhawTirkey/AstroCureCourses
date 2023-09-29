package com.astrocure.astrocurecourses.ui;

import static com.astrocure.astrocurecourses.utils.AppConstants.PROFILE_IMG;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.astrocure.astrocurecourses.R;
import com.astrocure.astrocurecourses.databinding.ActivityHomeBinding;
import com.astrocure.astrocurecourses.ui.fragment.CourseFragment;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityHomeBinding binding;
    CourseFragment courseFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSideNavigation();
//        binding.sideNav.getMenu().setGroupVisible(R.id.side_nav_group_class, false);
        binding.sideNav.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        courseFragment = new CourseFragment();
        setFragment(courseFragment);
    }

    private void setSideNavigation() {
        ImageView header_img = binding.sideNav.getHeaderView(0).findViewById(R.id.header_profile_img);
        Glide.with(getApplicationContext()).load(PROFILE_IMG).centerCrop().into(header_img);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.side_nav_class_schedule) {
            binding.sideNav.getMenu().setGroupVisible(R.id.side_nav_group_class, true);
        }
        binding.drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void setFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.mainContainer.getId(), fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
//        if (fragmentManager.findFragmentById(binding.mainContainer.getId()) instanceof HoroscopeFragment) {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                finishAffinity();
                finish();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_LONG).show();

            new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
        }
//        } else {
//            binding.bottomNav.setSelectedItemId(R.id.horoscope);
//        }
    }
}