package com.example.han.adding;

public class PreviewClass {
    int cnum;
    private String title;
    private String image;

    private boolean state;
    private String str;

    public PreviewClass(int cnum, String title, String image, boolean state, String str) {
        this.cnum = cnum;
        this.title = title;
        this.image = image;
        this.state = state;
        this.str = str;
    }

    public PreviewClass() {
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
