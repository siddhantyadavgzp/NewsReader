package com.apress.gerber.newsreader;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.ContentHandler;
import java.util.ArrayList;

public class News {

    @SerializedName("status")
    @Expose
    private String stats;

    @SerializedName("articles")
    @Expose
    private ArrayList<Content> content;

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public ArrayList<Content> getContent() {
        return content;
    }

    public void setContent(ArrayList<Content> content) {
        this.content = content;
    }

}
