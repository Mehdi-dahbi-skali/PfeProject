package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdpter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Post>posts;

    public MyAdpter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.view_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Post post=posts.get(position);
     holder.username.setText(post.getUsername());
     holder.username.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(view.getContext(), ProfileActivity.class);
             intent.putExtra("userId", post.getId());
             view.getContext().startActivity(intent);
         }
     });
     holder.desc.setText(posts.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
