package com.checkfer.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.checkfer.test.R;
import com.checkfer.test.models.LawyerModel;

import java.util.List;

public class LawyerRecycleViewAdapter extends RecyclerView.Adapter<LawyerRecycleViewAdapter.ViewHolder> {

    private final List<LawyerModel> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public LawyerRecycleViewAdapter(Context context, List<LawyerModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lawyer_listview_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LawyerModel lawyer = mData.get(position);
        holder.tvLawyerName.setText(lawyer.getName());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView tvLawyerName;

        ViewHolder(View itemView) {
            super(itemView);
            tvLawyerName = itemView.findViewById(R.id.tvLawyerName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public LawyerModel getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}