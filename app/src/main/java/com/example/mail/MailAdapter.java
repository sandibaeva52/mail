package com.example.mail;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;

public class MailAdapter extends RecyclerView.Adapter <MailAdapter.MailViewHolder> {
private Mails[] mailList;
private Context context;
private onClick click;

    public MailAdapter(Mails[] mailList, Context context) {
        this.mailList=mailList;
        this.click=click;
        this.context=context;
    }



    public static class MailViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDescription;
        public TextView tvTime;
        onClick click;
        int position;
        private Mails[] mailList;

        public MailViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvDescription=itemView.findViewById(R.id.tvDesc);
            tvTime=itemView.findViewById(R.id.tvTime);
itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        click.clicked(mailList[position]);
    }
});

    }


        public void setPosition(int position) {
            this.position=position;
        }
    }
    @NonNull
    @Override
    public MailAdapter.MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View v= layoutInflater.inflate(R.layout.mail_item,parent,false);
        return new MailViewHolder(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull MailAdapter.MailViewHolder holder, int position) {
Mails message=mailList[position];
        holder.tvName.setText(message.getName());
        holder.tvDescription.setText(message.getDescription());
        holder.tvTime.setText(message.getTime());
        
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return mailList.length;
    }

interface onClick{
        void clicked(Mails mail);
}
}
