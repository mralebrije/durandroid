package com.sduran.durandroid.fragments;

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

public class ContactFragment extends Fragment {

    @BindView(R.id.id_bnv_contactMenu)
    BottomNavigationView bottomNavigationView;

    private static int DEFAULT_TAB = R.id.id_action_email;
    private int selectedSection;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.id_action_email:
                        selectItem(R.id.id_action_email);
                        break;
                    case R.id.id_action_location:
                        selectItem(R.id.id_action_location);
                        break;
                    case R.id.id_action_phone:
                        selectItem(R.id.id_action_phone);
                        break;
                    case R.id.id_action_socialMedia:
                        selectItem(R.id.id_action_socialMedia);
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
                case R.id.id_action_email:
                    selectedFragment = new EmailFragment();
                    break;
                case R.id.id_action_location:
                    selectedFragment = new LocationFragment();
                    break;
                case R.id.id_action_phone:
                    selectedFragment = new PhoneFragment();
                    break;
                case R.id.id_action_socialMedia:
                    selectedFragment = new SocialMediaFragment();
                    break;
                default:
                    selectedSection = DEFAULT_TAB;
                    selectedFragment = new EmailFragment();
                    break;
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.id_sv_contactContentFrame, selectedFragment)
                    .commit();
        }
    }
}
