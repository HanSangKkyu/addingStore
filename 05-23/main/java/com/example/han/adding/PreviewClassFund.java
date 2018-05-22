package com.example.han.adding;

public class PreviewClassFund {
    int pnum;
    private String title;
    private String image;

    private boolean state;
    private String str;

    public PreviewClassFund(int pnum, String title, String image, boolean state, String str) {
        this.pnum = pnum;
        this.title = title;
        this.image = image;
        this.state = state;
        this.str = str;
    }

    public PreviewClassFund() {
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getPnum() {
        return pnum;
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
