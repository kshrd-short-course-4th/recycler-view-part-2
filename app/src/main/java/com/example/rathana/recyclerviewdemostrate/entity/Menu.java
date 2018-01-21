package com.example.rathana.recyclerviewdemostrate.entity;

/**
 * Created by RATHANA on 1/20/2018.
 */

public class Menu {
    public static final  int GRID=1;
    public static final  int STAGGERED=2;
    private int thumb;
    private String title;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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
