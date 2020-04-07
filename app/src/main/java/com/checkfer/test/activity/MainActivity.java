package com.checkfer.test.activity;

import android.os.Bundle;

import com.checkfer.test.R;
import com.checkfer.test.models.LawyerInstance;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.checkfer.test.adapter.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LawyerInstance.init();

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);


    }
}