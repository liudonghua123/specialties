package com.liudonghua.specialties.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.liudonghua.specialties.R;

import org.w3c.dom.Text;

/**
 * Created by liudonghua on 9/13/15.
 */
public class ProfileListAdapter extends RecyclerView.Adapter<ProfileListAdapter.ViewHolder> {

    String[] mDataset;
    public ProfileListAdapter(String[] dataset) {
        mDataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_item_profile, parent, false);
        TextView textView = (TextView) v.findViewById(R.id.item_text_view);
        ViewHolder vh = new ViewHolder(v, textView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mTextView.setText(mDataset[i]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView mTextView;
        ViewHolder(View v, TextView textView) {
            super(v);
            mView = v;
            mTextView = textView;
        }
    }
}
