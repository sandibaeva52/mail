package com.example.mail;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MailListFragment extends Fragment implements MailAdapter.itemClick{
    FragmentManager fragmentManager;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mailAdapter;
    private  ArrayList<Mails> mailList;
    private RecyclerView.LayoutManager layoutManager;
    private MailDetailFragment mailDetailFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mail_list_fragment, container, false);
        mailList = new ArrayList<>();
    mailList.add(new Mails("Assem Sandibayeva", "Some text","12:03"));
        mailList.add(new Mails("Aigerim Kaimakova", "Some text","13:30"));
        mailList.add(new Mails("Aktoty Saubayeva", "Some text","14:20"));
        mailList.add(new Mails("Aktoty Saubayeva", "Some text","15:20"));
        mailList.add(new Mails("Aktoty Saubayeva", "Some text","18:20"));
        mailList.add(new Mails("Aktoty Saubayeva", "Some text","20:20"));
        mailList.add(new Mails("Aktoty Saubayeva", "Some text","8:20"));
        mailList.add(new Mails("Aktoty Saubayeva", "Some text","8:47"));
        mailList.add(new Mails("Assem Sandibayeva", "Some text","12:53"));
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getActivity());
        mailAdapter=new MailAdapter(mailList, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mailAdapter);
        return view;
    }

    @Override
    public void onClick(int position) {
        MailDetailFragment mailDetailFragment = (MailDetailFragment) getFragmentManager().findFragmentById(R.id.MailDetail);
        mailDetailFragment.getDetail(mailList.get(position));
    }
}