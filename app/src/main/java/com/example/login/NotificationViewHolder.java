package com.example.login;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationViewHolder extends RecyclerView.ViewHolder  {

    TextView username , action;
    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
        username=itemView.findViewById(R.id.usernameName);
        action=itemView.findViewById(R.id.action);



    }
}
