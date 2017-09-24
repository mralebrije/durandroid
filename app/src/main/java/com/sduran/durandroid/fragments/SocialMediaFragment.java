package com.sduran.durandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sduran.durandroid.R;

import butterknife.ButterKnife;

/**
 * Created by sduranware on 23/09/2017.
 */

public class SocialMediaFragment extends Fragment {

    public SocialMediaFragment() {
        // Required empty public constructor
    }

    public static SocialMediaFragment newInstance(String param1, String param2) {
        SocialMediaFragment fragment = new SocialMediaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_social_media, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

}
