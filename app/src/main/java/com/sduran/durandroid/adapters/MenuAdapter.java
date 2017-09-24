package com.sduran.durandroid.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sduran.durandroid.R;
import com.sduran.durandroid.utils.Events;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by sduranware on 23/09/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private RecyclerView mRecyclerView;
    private String mNavTitles[];
    private int mIcons[];
    private int mSelectedPosition;
    private View mSelectedView;

    private String name;
    private int profile;
    private String email;



    public MenuAdapter(RecyclerView mRecyclerView, String titles[],int icons[],String name,String email, int profile, int mSelectedPosition){
        this.mRecyclerView = mRecyclerView;
        this.mNavTitles = titles;
        this.mIcons = icons;
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.mSelectedPosition = mSelectedPosition;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int holderId;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView name;
        TextView email;
        View view;

        public ViewHolder(final View itemView, int ViewType) {
            super(itemView);

            if(TYPE_ITEM == ViewType ) {
                textView = (TextView) itemView.findViewById(R.id.id_tv_menuSection);
                imageView = (ImageView) itemView.findViewById(R.id.id_iv_menuIcon);
                holderId = TYPE_ITEM;
                view = itemView;
            }
            else{
                name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.email);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                holderId = TYPE_HEADER;
            }
        }
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (TYPE_ITEM == viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_list,parent,false);
            ViewHolder vhItem = new ViewHolder(v,viewType);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!v.isSelected()){
                        if(mSelectedView!=null){
                            mSelectedView.setSelected(false);
                        }

                        v.setSelected(true);
                        mSelectedPosition = mRecyclerView.getChildPosition(v) - 1;
                        mSelectedView = v;
                    }

                    EventBus.getDefault().post(new Events.OnSectionSelected(mSelectedPosition));
                }
            });

            return vhItem;
        } else if (TYPE_HEADER == viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);
            ViewHolder vhHeader = new ViewHolder(v,viewType);

            return vhHeader;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(final MenuAdapter.ViewHolder holder, final int position) {

        if(TYPE_ITEM  == holder.holderId) {

            final int offsetPosition = position - 1;

            holder.textView.setText(mNavTitles[offsetPosition]);
            holder.imageView.setImageResource(mIcons[offsetPosition]);

            if(offsetPosition == mSelectedPosition){
             holder.view.setSelected(true);
             mSelectedView = holder.view;
            }
        }
        else{
            holder.profile.setImageResource(profile);
            holder.name.setText(name);
            holder.email.setText(email);
        }
    }

    @Override
    public int getItemCount() {
        return mNavTitles.length+1;
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }


}