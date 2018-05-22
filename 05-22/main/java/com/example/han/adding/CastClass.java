package com.example.han.adding;

public class CastClass {
    private int cnum;
    private String title;
    private String content;
    private String preperationdate;
    private String member;

    private boolean state;
    private String str;

    public CastClass(int cnum, String title, String content, String preperationdate, String member, boolean state, String str) {
        this.cnum = cnum;
        this.title = title;
        this.content = content;
        this.preperationdate = preperationdate;
        this.member = member;
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

    public String getPreperationdate() {
        return preperationdate;
    }

    public void setPreperationdate(String preperationdate) {
        this.preperationdate = preperationdate;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
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
