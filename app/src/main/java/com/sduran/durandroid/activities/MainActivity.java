package com.sduran.durandroid.activities;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.sduran.durandroid.R;
import com.sduran.durandroid.adapters.MenuAdapter;
import com.sduran.durandroid.fragments.ContactFragment;
import com.sduran.durandroid.fragments.ProfessionalFragment;
import com.sduran.durandroid.utils.Events;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sduranware on 23/09/2017.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_dl_navDrawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.id_lv_leftDrawer)
    RecyclerView mDrawerList;
    @BindView(R.id.id_tb_mainToolbar)
    Toolbar toolbar;
    @BindView(R.id.id_tb_title)
    TextView toolbarTitle;

    private ActionBarDrawerToggle mDrawerToggle;
    RecyclerView.LayoutManager mLayoutManager;

    private String[] menuTitles;
    private int[] menuIcons = {R.mipmap.ic_business, R.mipmap.ic_school, R.mipmap.ic_account, R.mipmap.ic_contact_mail};
    private int profilePhoto = R.drawable.profile_photo;
    private String currentTitle;
    private int selectedSection;
    private MenuAdapter menuAdapter;

    private static final int DEFAULT_SECTION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // get all menu titles
        menuTitles = getResources().getStringArray(R.array.titles_navDrawer);
        // set default section
        currentTitle = menuTitles[DEFAULT_SECTION];
        selectedSection = DEFAULT_SECTION;

        setToolbar();
        setToggle();
        initializeMenuListView();

        selectItem(selectedSection);

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void setToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.string.detail_drawerOpen,  /* "open drawer" description */
                R.string.detail_drawerClose  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                setToolbarTitle(currentTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setToolbarTitle(currentTitle);
            }
        };
        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeButtonEnabled(true);
        }


        setToolbarTitle(currentTitle);
    }

    public void setToolbarTitle(String title) {
        currentTitle = title;
        toolbarTitle.setText(currentTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    private void initializeMenuListView() {

        mLayoutManager = new LinearLayoutManager(this);
        mDrawerList.setLayoutManager(mLayoutManager);

        mDrawerList.setHasFixedSize(true);

        // Set the adapter for the list view
        menuAdapter = new MenuAdapter(mDrawerList, menuTitles, menuIcons, getString(R.string.sduran_name), getString(R.string.sduran_email), profilePhoto, DEFAULT_SECTION);
        mDrawerList.setAdapter(menuAdapter);
    }

    private void selectItem(int position) {

        if (position != selectedSection) {

            selectedSection = position;

            // Create a new fragment and specify the section to show based on position
            Fragment selectedFragment;

            switch (selectedSection) {
                case 0:
                    selectedFragment = new ProfessionalFragment();
                    break;
                case 1:
                    selectedFragment = new ProfessionalFragment();
                    break;
                case 2:
                    selectedFragment = new ProfessionalFragment();
                    break;
                case 3:
                    selectedFragment = new ContactFragment();
                    break;
                default:
                    selectedFragment = new ProfessionalFragment();
                    break;
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.id_fl_contentFrame, selectedFragment)
                    .commit();

            setToolbarTitle(menuTitles[selectedSection]);
        }

        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sectionSelected(Events.OnSectionSelected event) {
        selectItem(event.section);
    }
}
