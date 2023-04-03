package com.example.login;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView profileimg,post;
    TextView username , desc,count,countcmt;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        //profileimg=itemView.findViewById(R.id.profileimage);
       // post=itemView.findViewById(R.id.poste);
        username=itemView.findViewById(R.id.UsernameView);
        desc=itemView.findViewById(R.id.desc);
        //count=itemView.findViewById(R.id.count);
        //countcmt=itemView.findViewById(R.id.countcommentaire);
    }
}
