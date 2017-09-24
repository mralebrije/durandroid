package com.sduran.durandroid.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.sduran.durandroid.R;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sduranware on 23/09/2017.
 */

public class EmailFragment extends Fragment {

    @BindView(R.id.id_et_from)
    EditText etFromEmail;
    @BindView(R.id.id_et_message)
    EditText etMessage;

    private static final int REQUEST_CODE_EMAIL = 2409;

    public EmailFragment() {
        // Required empty public constructor
    }

    public static EmailFragment newInstance(String param1, String param2) {
        EmailFragment fragment = new EmailFragment();
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
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.id_btn_sendMessage)
    public void sendEmail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{getString(R.string.sduran_email)});
        i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.title_emailSubject) + " - " + etFromEmail.getText() );
        i.putExtra(Intent.EXTRA_TEXT   , etMessage.getText());
        try {
            startActivityForResult(Intent.createChooser(i, getString(R.string.detail_sendEmail)),REQUEST_CODE_EMAIL);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override   public void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode == REQUEST_CODE_EMAIL) {
        new LovelyStandardDialog(getContext())
                .setTopColorRes(R.color.colorPrimary)
                .setButtonsColorRes(R.color.colorPrimary)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.detail_thankYou)
                .setMessage(R.string.detail_feedbackEmailSent)
                .setPositiveButton(android.R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .show();
       }
    }
}
