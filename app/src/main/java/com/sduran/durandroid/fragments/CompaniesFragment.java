package com.sduran.durandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sduran.durandroid.R;
import com.sduran.durandroid.adapters.CompaniesAdapter;
import com.sduran.durandroid.adapters.MenuAdapter;
import com.sduran.durandroid.dto.resources.CompanyResource;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sduranware on 23/09/2017.
 */

public class CompaniesFragment extends Fragment {

    @BindView(R.id.id_rv_companies)
    RecyclerView recyclerView;


    RecyclerView.LayoutManager mLayoutManager;
    CompaniesAdapter companiesAdapter;

    List<CompanyResource> mCompanies;

    public CompaniesFragment() {
        // Required empty public constructor
    }

    public static CompaniesFragment newInstance(String param1, String param2) {
        CompaniesFragment fragment = new CompaniesFragment();
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
        View view = inflater.inflate(R.layout.fragment_companies, container, false);
        ButterKnife.bind(this, view);

        initializeData();
        initializeRecycler();

        return view;
    }

    private void initializeData() {

        mCompanies = buildCompanies();

    }

    private List<CompanyResource> buildCompanies() {

        List<CompanyResource> companiesList = new ArrayList<>();

        CompanyResource company1 = new CompanyResource("Contrast Security",
                "Welcome to the Era of Self-Protecting Software",
                "https://www.contrastsecurity.com/",
                "Baltimore, USA (2017)",
                "Web App Developer",
                "G11n, I18n, L10n, TeamServer, Defect Tracker",
                "Java, Jenkins, Spring, Hibernate, Angular JS, JavaScript, MySQL, Maven, angular-translate, Git, Atlassian, SCRUM, Go To Meeting",
                "https://avatars0.githubusercontent.com/u/5577345?v=4&s=200");

        CompanyResource company2 = new CompanyResource("Loggap","Viajeros que ayudan",
                "https://www.facebook.com/loggap/",
                "Paris, France (2016)",
                "CTO",
                "Loggap Android Native App, Loggap Backend, Loggap SDK, SCRUM Introduction, French Tech Ticket",
                "Java, Android SDK, Google Auto Complete, Firebase Cloud Messaging, Spring, Hibernate, SCRUM, Git",
                "https://www.google.co.id/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=&url=https%3A%2F%2Ftwitter.com%2Floggap&psig=AFQjCNEsCdoj-Odnue6GCAUV1lbDdxDUuw&ust=1506386711560460");

        CompanyResource company3 = new CompanyResource("iWA Consolti",
                "Software Factory",
                "iwa.com.mx",
                "Orizaba, Mexico (2014-2017)",
                "Web App Developer, Native Android App Developer, Mobile App Project Leader",
                "Cobranza Móvil 2.0, Tu Fiesta Móvil, Grade Recorder, Loggap, Touch Taxi, Covadonga App, Tyasa Tracking",
                "Java, Android SDK, Nexus Deployment, Spring Boot, Hibernate, FCM, JavaScript, MySQL, XML Design, Git, SCRUM, Atlassian, Maven, Gradle, MVC, Google APIs, FB Login API, SQLite, RESTful Services",
                "https://www.google.co.id/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjEu5HRjL_WAhVR52MKHflYCjgQjRwIBw&url=https%3A%2F%2Fwww.f6s.com%2Fiwaconsolti&psig=AFQjCNE6V51NXbF8hp_jOfUrXhGQtNu6Kw&ust=1506386327420911");

        companiesList.add(company1);
        companiesList.add(company2);
        companiesList.add(company3);

        return  companiesList;
    }

    private void initializeRecycler() {

        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        //TODO: recyclerView.setHasFixedSize(true);

        // Set the adapter for the recycler view
        companiesAdapter = new CompaniesAdapter(mCompanies);
        recyclerView.setAdapter(companiesAdapter);
    }
}
