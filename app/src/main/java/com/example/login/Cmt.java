package com.example.login;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Cmt implements Parcelable {
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

    protected Cmt(Parcel in) {
        username = in.readString();
        content = in.readString();
        id = in.readString();
    }

    public static final Creator<Cmt> CREATOR = new Creator<Cmt>() {
        @Override
        public Cmt createFromParcel(Parcel in) {
            return new Cmt(in);
        }

        @Override
        public Cmt[] newArray(int size) {
            return new Cmt[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(content);
        parcel.writeString(id);
    }
}
