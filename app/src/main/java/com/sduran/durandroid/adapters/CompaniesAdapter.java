package com.sduran.durandroid.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sduran.durandroid.R;
import com.sduran.durandroid.dto.resources.CompanyResource;
import com.sduran.durandroid.helpers.Events;
import com.sduran.durandroid.helpers.ViewHolderManager;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by sduranware on 23/09/2017.
 */

public class CompaniesAdapter extends RecyclerView.Adapter {

    List<CompanyResource> companies;

    public CompaniesAdapter(List<CompanyResource> companies) {
        this.companies = companies;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        RecyclerView.ViewHolder vhItem = new ViewHolderManager.CompanyViewHolder(view);

        return vhItem;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder abstractHolder, final int position) {

        ViewHolderManager.CompanyViewHolder holder = (ViewHolderManager.CompanyViewHolder) abstractHolder;

        CompanyResource companyResource = companies.get(position);

        holder.name.setText(companyResource.getName());
        holder.description.setText(companyResource.getDescription());
        holder.reference.setText(companyResource.getReference());
        holder.location.setText(companyResource.getLocation());
        holder.position.setText(companyResource.getPosition());
        holder.projects.setText(companyResource.getProjects());
        holder.technologies.setText(companyResource.getTechnologies());
    }

    @Override
    public int getItemCount() {
        if (this.companies != null)
            return this.companies.size();
        else return 0;
    }



}