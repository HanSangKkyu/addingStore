package com.example.han.adding;

public class CastClass {
    private int cnum;
    private String title;
    private String content;
    private String date;
    private String image;

    private boolean state;
    private String str;

    public CastClass(int cnum, String title, String content, String date, String image, boolean state, String str) {
        this.cnum = cnum;
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
        this.state = state;
        this.str = str;
    }

    public CastClass() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
