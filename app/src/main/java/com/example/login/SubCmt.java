package com.example.login;

import java.util.ArrayList;
import java.util.List;

public class SubCmt {
    private String username;
    private String content;
    private  String id;

    private String idCmt;
    private List<Reactions> reactions=new ArrayList<Reactions>();

    public SubCmt(String username, String content, String id,String idCmt, List<Reactions> reactions) {
        this.username = username;
        this.content = content;
        this.id = id;
        this.reactions = reactions;
        this.idCmt=idCmt;
    }

    public String getIdCmt() {
        return idCmt;
    }

    public void setIdCmt(String idCmt) {
        this.idCmt = idCmt;
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
