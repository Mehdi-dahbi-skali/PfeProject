package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentaireAdapter extends RecyclerView.Adapter<CommentaireHolder>{

    Context context;

    List<Cmt> cmts;

    List<SubCmt> subcmts;

    public CommentaireAdapter(Context context, List<Cmt> cmts) {
        this.context = context;
        this.cmts = cmts;
    }

    @NonNull
    @Override
    public CommentaireHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentaireHolder(LayoutInflater.from(context).inflate(R.layout.cmt_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentaireHolder holder, int position) {
        final Cmt cmt=cmts.get(position);

        holder.username.setText(cmt.getUsername());
        holder.cmt.setText(cmt.getContent());
        holder.countSubcmt.setText(cmt.getSubcmts().size()+"");
        holder.countReaction.setText(String.valueOf(cmt.getReactions().size()));


    }

    @Override
    public int getItemCount() {
        return cmts.size();
    }
}
