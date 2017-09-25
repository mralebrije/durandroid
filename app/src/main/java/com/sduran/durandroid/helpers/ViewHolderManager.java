package com.sduran.durandroid.helpers;

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sduran.durandroid.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

/**
 * Created by sduranware on 24/09/2017.
 */

public class ViewHolderManager {

    public static class CompanyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView description;
        public Button reference;
        public TextView location;
        public TextView position;
        public TextView projects;
        public TextView technologies;
        public ImageView logo;

        public CompanyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.id_tv_companyName);
            description = (TextView) itemView.findViewById(R.id.id_tv_companyDescription);
            reference = (Button) itemView.findViewById(R.id.id_btn_companyReference);
            location = (TextView) itemView.findViewById(R.id.id_tv_companyLocation);
            position = (TextView) itemView.findViewById(R.id.id_tv_companyPosition);
            projects = (TextView) itemView.findViewById(R.id.id_tv_companyProjects);
            technologies = (TextView) itemView.findViewById(R.id.id_tv_companyTechs);

        }
    }
}
