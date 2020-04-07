package com.checkfer.test.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.checkfer.test.R;
import com.checkfer.test.models.LawyerInstance;
import com.checkfer.test.adapter.LawyerRecycleViewAdapter;
import com.checkfer.test.activity.LawyerDetailsActivity;

public class LawyerListFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private LawyerRecycleViewAdapter adapter;
    private int currentPosition = 1;

    public static LawyerListFragment newInstance(int index) {
        LawyerListFragment fragment = new LawyerListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        currentPosition = 1;
        if (getArguments() != null) {
            currentPosition = getArguments().getInt(ARG_SECTION_NUMBER);
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lawyerlist, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.lawyerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new LawyerRecycleViewAdapter(getContext(), LawyerInstance.getLawyers(currentPosition));

        adapter.setClickListener((view, position) -> {

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

                final View ivLawyerPhoto = view.findViewById(R.id.ivLawyerPhoto);
                final View tvLawyerName = view.findViewById(R.id.tvLawyerName);
                final View tvLawyerSpeciality = view.findViewById(R.id.tvLawyerSpeciality);
                final View cardView = view.findViewById(R.id.cardView);
                final View verifiedIcon = view.findViewById(R.id.verifiedIcon);

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                        getActivity(),
                        Pair.create(verifiedIcon, verifiedIcon.getTransitionName()),
                        Pair.create(cardView, cardView.getTransitionName()),
                        Pair.create(ivLawyerPhoto, ivLawyerPhoto.getTransitionName()),
                        Pair.create(tvLawyerSpeciality, tvLawyerSpeciality.getTransitionName()),
                        Pair.create(tvLawyerName, tvLawyerName.getTransitionName()));

                Intent intent = new Intent(getActivity(), LawyerDetailsActivity.class);
                intent.putExtra("lawyer", adapter.getItem(position)); //Todo make a const
                startActivity(intent, activityOptions.toBundle());
            } else {

                Intent intent = new Intent(getActivity(), LawyerDetailsActivity.class);
                intent.putExtra("lawyer", adapter.getItem(position)); //Todo make a const
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        return root;
    }

}