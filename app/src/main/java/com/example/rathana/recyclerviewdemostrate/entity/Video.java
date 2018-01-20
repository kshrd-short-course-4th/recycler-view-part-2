package com.example.rathana.recyclerviewdemostrate.entity;

/**
 * Created by RATHANA on 1/20/2018.
 */

public class Video  {
    private int thumb;
    private String title;
    private String channelName;
    private String viewer;

    public Video(int thumb, String title, String channelName, String viewer) {
        this.thumb = thumb;
        this.title = title;
        this.channelName = channelName;
        this.viewer = viewer;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getViewer() {
        return viewer;
    }

    public void setViewer(String viewer) {
        this.viewer = viewer;
    }
}
