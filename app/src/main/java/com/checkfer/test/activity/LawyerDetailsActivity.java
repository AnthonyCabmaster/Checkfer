package com.checkfer.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.checkfer.test.R;
import com.checkfer.test.databinding.ActivityLawyerDetailsBinding;
import com.checkfer.test.models.LawyerModel;
import com.checkfer.test.utils.PaintUtils;

import java.util.Objects;

public class LawyerDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLawyerDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lawyer_details);

        Intent intent = getIntent();
        LawyerModel lawyerModel = (LawyerModel) Objects.requireNonNull(intent.getExtras()).getSerializable("lawyer");

        //If for some reason we don't get a Model then we need to do something about that.
        //For this case the Data is static and this won't happen. But if we have data that is from JSON that could change then we need to account for this properly
        assert lawyerModel != null;

        //setup Binding which saves all the crappy setText
        binding.setLawyer(lawyerModel);

        findViewById(R.id.iconBack).setOnClickListener(view -> onBackPressed());

        TextView tvFreeOffer = findViewById(R.id.tvFreeOffer);

        //We can return ValueAnimator so this class can STOP the animation if it wanted too
        PaintUtils.animateGradientView(findViewById(R.id.button), getResources().getColor(R.color.gradient_start), getResources().getColor(R.color.gradient_end), 1000);
        PaintUtils.setBackgroundForTextInTextView(new int[]{getResources().getColor(R.color.gradient_start), getResources().getColor(R.color.gradient_end)}, tvFreeOffer);

        //Here is where we would Databind all of our texts / images, this isn't needed for the test
        //we would use native databinding rather than a library since the main one is deprecated
        //https://developer.android.com/topic/libraries/data-binding/expressions

    }
}
