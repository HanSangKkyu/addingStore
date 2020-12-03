package com.example.han.adding;

public class PreviewClassFund {
    int pnum;
    private String pname;
    private String image;

    private boolean state;
    private String str;

    public PreviewClassFund(int pnum, String pname, String image, boolean state, String str) {
        this.pnum = pnum;
        this.pname = pname;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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
