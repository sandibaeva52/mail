package com.example.mail;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MailListFragment extends Fragment  {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mailAdapter;
    private Mails[] mailList;
    private RecyclerView.LayoutManager layoutManager;
private MailDetailFragment mailDetailFragment;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public void clicked(int position) {
//MailDetailFragment mailDetailFragment=(MailDetailFragment) getFragmentManager().findFragmentById(R.id.MailDetail);
//mailDetailFragment.get(position);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mail_list_fragment, container, false);
mailList= DataModel.getMailList();
        recyclerView=view.findViewById(R.id.recyclerView);
recyclerView.setHasFixedSize(true);
layoutManager=new LinearLayoutManager(getActivity());
mailAdapter=new MailAdapter(mailList, getContext());
recyclerView.setLayoutManager(layoutManager);
recyclerView.setAdapter(mailAdapter);
        return view;
    }


//    @Override
//    public void clicked(Mails mail) {
//
//    }
}