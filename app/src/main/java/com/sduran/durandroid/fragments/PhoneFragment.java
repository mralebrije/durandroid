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

public class PhoneFragment extends Fragment {

    public PhoneFragment() {
        // Required empty public constructor
    }

    public static PhoneFragment newInstance(String param1, String param2) {
        PhoneFragment fragment = new PhoneFragment();
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
        View view = inflater.inflate(R.layout.fragment_phone, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

}
