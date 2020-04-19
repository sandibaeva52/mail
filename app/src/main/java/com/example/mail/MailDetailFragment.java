package com.example.mail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MailDetailFragment extends Fragment {
    public TextView tvName;
    public TextView tvDesc;
    Mails mails;
    public MailDetailFragment(){

    }

    public MailDetailFragment(Mails mails) {
        this.mails=mails;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mails!=null){
            tvName=getView().findViewById(R.id.tvName);
            tvName.setText(mails.getName());

            tvDesc=getView().findViewById(R.id.tvDesc);
            tvDesc.setText(mails.getDescription());
        }
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable android.view.ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mail_detail_fragment, container,false);

//
//        tvName.setText(mails.getName());
//        tvDesc.setText(mails.getDescription());
        return v;
    }




}