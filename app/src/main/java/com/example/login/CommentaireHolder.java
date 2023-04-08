package com.example.login;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentaireHolder  extends  RecyclerView.ViewHolder{

    ImageView profileimg;
    TextView username , cmt,countReaction,countSubcmt,replyCmt;



    public CommentaireHolder(@NonNull View itemView) {
        super(itemView);
        username=itemView.findViewById(R.id.usernameCmt);
        cmt=itemView.findViewById(R.id.commantairet);
        countReaction=itemView.findViewById(R.id.cmtCountReactions);
        countSubcmt=itemView.findViewById(R.id.cmtCountCmt);
        replyCmt=itemView.findViewById(R.id.replayBtn);

    }
}
