package com.example.mail;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;

public class MailAdapter extends RecyclerView.Adapter <MailAdapter.MailViewHolder> {
    private ArrayList<Mails> mailList;
    private itemClick click;
    public static class MailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivIcon;
        public TextView tvName;
        public TextView tvDesc;
        public TextView tvTime;

        public itemClick click;
        public MailViewHolder(View itemView, itemClick click) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.icon);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvTime = itemView.findViewById(R.id.tvTime);

            this.click = click;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            click.onClick(getAdapterPosition());
        }
    }

    public MailAdapter(ArrayList<Mails> mailList, itemClick click) {
        this.mailList = mailList;
        this.click = click;
    }

    @Override
    public MailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mail_item, parent, false);
        return new MailViewHolder(v, click);
    }

    @Override
    public void onBindViewHolder(MailViewHolder holder, int position) {
        Mails currentItem = mailList.get(position);

        holder.tvName.setText(currentItem.getName());
        holder.tvDesc.setText(currentItem.getDescription());
        holder.tvTime.setText(currentItem.getTime());

    }

    @Override
    public int getItemCount() {
        return mailList.size();
    }

    interface itemClick{
        void onClick(int position);
    }
}