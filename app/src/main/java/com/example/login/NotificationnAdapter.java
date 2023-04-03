package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationnAdapter extends RecyclerView.Adapter<NotificationViewHolder>{

    Context context;
    List<Notification> notifs;

    public NotificationnAdapter(Context context, List<Notification> notifs) {
        this.context = context;
        this.notifs = notifs;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationViewHolder(LayoutInflater.from(context).inflate(R.layout.view_notification,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        final Notification notif=notifs.get(position);
        holder.username.setText(notif.getUsername());
        holder.action.setText(notif.getAction());
    }

    @Override
    public int getItemCount() {
        return notifs.size();
    }
}
