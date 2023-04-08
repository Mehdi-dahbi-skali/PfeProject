package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyAdpter extends RecyclerView.Adapter<MyViewHolder> {


    Context context;
    List<Post>posts;
    List<Cmt> cmts;
    String username;





    public MyAdpter(Context context, List<Post> posts,String username) {
        this.context = context;
        this.posts = posts;
         this.username=username;
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
            // Intent intentCmt = new Intent(view.getContext(), CommentaireFragment.class);
             intent.putExtra("userId", post.getId());
             intent.putExtra("username", post.getUsername()+"");
             cmts=post.getCmts();
             intent.putExtra("CmtsCount",cmts.size());
             //intent.putExtra("ReactionsCount",post.getReactions().size());
             view.getContext().startActivity(intent);

             //intentCmt.putExtra("cmts",new ArrayList<>(cmts));
             //intentCmt.putExtra("CmtsCount",cmts.size());
             //view.getContext().startActivity(intentCmt);
         }
     });
     holder.desc.setText(posts.get(position).getDesc());
     holder.countcmt.setText(post.getCmts().size()+"");
     holder.count.setText(post.getReactions().size()+"");

     holder.countcmt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            // cmts=post.getCmts();

            // Intent intent = new Intent(view.getContext(), CommentaireActivity.class);
            // intent.putExtra("cmts",cmts);
             //intent.putExtra("countReaction",post.getReactions().size()+"");
             //intent.putExtra("reactions",new ArrayList<>(post.getReactions()));
             //view.getContext().startActivity(intent);

             List<Cmt> cmtList = new ArrayList<>();// Assume this list is already populated with Cmt objects
             cmtList=post.getCmts();


             ArrayList<Cmt> cmtArrayList = new ArrayList<>(cmtList);


             Intent intent = new Intent(view.getContext(), CommentaireActivity.class);
             intent.putExtra("cmts",cmtArrayList);
             intent.putExtra("username",username);
             view.getContext().startActivity(intent);


             //Intent intent = new Intent(context, CommentaireActivity.class);
             //intent.putParcelableArrayListExtra("myList", cmts);
             //context.startActivity(intent);

         }
     });
    }
    public interface OnSubCmtClickListener {
        void onSubCmtClick(List<SubCmt> subCmts);
    }
    @Override
    public int getItemCount() {
        return posts.size();
    }
}
