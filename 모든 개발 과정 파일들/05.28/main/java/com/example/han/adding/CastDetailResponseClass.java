package com.example.han.adding;

public class CastDetailResponseClass {
    int cnum;
    String title;
    String content;
    String date;
    String image;
    boolean state;
    String str;

    public CastDetailResponseClass(int cnum, String title, String content, String date, String image) {
        this.cnum = cnum;
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getCnum() {
        return cnum;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public boolean isState() {
        return state;
    }

    public String getStr() {
        return str;
    }
}
