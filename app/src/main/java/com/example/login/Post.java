package com.example.login;

import java.util.ArrayList;
import java.util.List;

public class Post {
    String username;
    int img;
    String id;

    String desc;
    List<Reactions> reactions=new ArrayList<Reactions>();
    List<Cmt> cmts=new ArrayList<Cmt>();
    String imgProfile;

    public Post(String username,String desc,String id , List<Reactions>reactions,List<Cmt>cmts) {
        this.username = username;
      //  this.img = img;
        this.id = id;
        this.desc=desc;
        this.reactions=reactions;
        this.cmts=cmts;
    }

    public List<Reactions> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reactions> reactions) {
        this.reactions = reactions;
    }

    public List<Cmt> getCmts() {
        return cmts;
    }

    public void setCmts(List<Cmt> cmts) {
        this.cmts = cmts;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Post() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
