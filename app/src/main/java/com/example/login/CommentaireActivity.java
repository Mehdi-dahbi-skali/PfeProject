package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommentaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_commentaire);
        final ImageView close = findViewById(R.id.colseBtn) ;
        final ImageView addBtn=findViewById(R.id.addBtnCmt);
        final TextView cmtNew =findViewById(R.id.cmtCreate);
        List<SubCmt> subcmts=new ArrayList<SubCmt>();
        List<Reactions> reactions=new ArrayList<Reactions>();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DashboardActivity.class);
                view.getContext().startActivity(intent);
            }
        });


        Intent intent = getIntent();
        ArrayList<Cmt> cmts = intent.getParcelableArrayListExtra("cmts");
        String username=intent.getStringExtra("username");
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();


        if (cmts != null){
            List<Cmt> cmtList = new ArrayList<>();
            cmtList.addAll(cmts);
            RecyclerView recyclerView = findViewById(R.id.ComentaireRecycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new CommentaireAdapter(getApplicationContext(),cmtList));
        }
           addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Cmt newcmt = new Cmt(username+"",cmtNew.getText()+"",subcmts,"123",reactions);
                    //cmts.add(newcmt);
                    //ArrayList<Cmt> cmtArrayList = new ArrayList<>(cmts);
                    //Intent intent = new Intent(view.getContext(), CommentaireActivity.class);
                    //intent.putExtra("cmts",cmtArrayList);
                    //view.getContext().startActivity(intent);
                    Toast.makeText(CommentaireActivity.this, "hhhh", Toast.LENGTH_SHORT).show();
                }
            });



    }
}