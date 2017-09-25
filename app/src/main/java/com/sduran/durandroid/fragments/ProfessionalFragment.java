package com.sduran.durandroid.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.sduran.durandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sduranware on 23/09/2017.
 */

public class ProfessionalFragment extends Fragment {


    @BindView(R.id.id_bnv_professionalMenu)
    BottomNavigationView bottomNavigationView;

    private static int DEFAULT_TAB = R.id.id_action_companies;
    private int selectedSection;

    public ProfessionalFragment() {
        // Required empty public constructor
    }

    public static ProfessionalFragment newInstance(String param1, String param2) {
        ProfessionalFragment fragment = new ProfessionalFragment();
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
        View view = inflater.inflate(R.layout.fragment_professional, container, false);
        ButterKnife.bind(this, view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.id_action_companies:
                        selectItem(R.id.id_action_companies);
                        break;
                    case R.id.id_action_skills:
                        selectItem(R.id.id_action_skills);
                        break;
                    case R.id.id_action_expertise:
                        selectItem(R.id.id_action_expertise);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        selectItem(-1);

        return view;
    }

    private void selectItem(int position) {

        if (position != selectedSection) {

            selectedSection = position;

            // Create a new fragment and specify the section to show based on position
            Fragment selectedFragment;

            switch (selectedSection) {
                case R.id.id_action_companies:
                    selectedFragment = new CompaniesFragment();
                    break;
                case R.id.id_action_skills:
                    selectedFragment = new CompaniesFragment();
                    break;
                case R.id.id_action_expertise:
                    selectedFragment = new CompaniesFragment();
                    break;
                default:
                    selectedSection = DEFAULT_TAB;
                    selectedFragment = new CompaniesFragment();
                    break;
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.id_sv_professionalContentFrame, selectedFragment)
                    .commit();
        }
    }
}
