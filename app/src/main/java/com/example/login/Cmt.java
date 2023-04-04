package com.example.login;

import java.util.ArrayList;
import java.util.List;

public class Cmt {
    private String username;
    private String content;
    private List<SubCmt> Subcmts=new ArrayList<SubCmt>();
    private  String id;
    private List<Reactions> reactions=new ArrayList<Reactions>();

    public Cmt(String username, String content, List<SubCmt> subcmts, String id, List<Reactions> reactions) {
        this.username = username;
        this.content = content;
        Subcmts = subcmts;
        this.id = id;
        this.reactions = reactions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<SubCmt> getSubcmts() {
        return Subcmts;
    }

    public void setSubcmts(List<SubCmt> subcmts) {
        Subcmts = subcmts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Reactions> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reactions> reactions) {
        this.reactions = reactions;
    }
}
