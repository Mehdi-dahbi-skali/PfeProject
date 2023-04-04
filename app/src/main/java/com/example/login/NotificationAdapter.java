package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder>{

    Context context;
    List<SubCmt> subcmts;
    List<Cmt> cmts;
    List<Reactions> reactions;

    public NotificationAdapter(Context context,List<Cmt>cmts) {
        this.context = context;
        this.cmts = cmts;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationViewHolder(LayoutInflater.from(context).inflate(R.layout.cmt_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
