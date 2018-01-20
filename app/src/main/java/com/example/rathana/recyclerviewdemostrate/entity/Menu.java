package com.example.rathana.recyclerviewdemostrate.entity;

/**
 * Created by RATHANA on 1/20/2018.
 */

public class Menu {
    private int thumb;
    private String title;

    public Menu(int thumb, String title) {
        this.thumb = thumb;
        this.title = title;
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
}
