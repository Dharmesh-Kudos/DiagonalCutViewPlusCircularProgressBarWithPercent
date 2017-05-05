package com.tasol.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tasol on 5/5/17.
 */

public class IndoLyticsSpeakerInfoAdapter extends Fragment {

    Context context;
    private String percentArray;
    private String presentArray;

    ProgressBar progressBar;
    TextView tvProgress,tvPresent;

    public IndoLyticsSpeakerInfoAdapter() {
    }

    public IndoLyticsSpeakerInfoAdapter(Context context, String percentArray, String presentArray) {
        this.context = context;
        this.percentArray = percentArray;
        this.presentArray = presentArray;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.creative, container, false);
        progressBar= (ProgressBar) v.findViewById(R.id.progressBar);
        tvProgress= (TextView) v.findViewById(R.id.tvProgress);
        tvPresent= (TextView) v.findViewById(R.id.tvPresent);
        progressBar.setProgress(Integer.parseInt(percentArray));
        tvProgress.setText(percentArray+"%");
        tvPresent.setText("Lectures Attended - "+presentArray+" / 100");
        return v;
    }


}
