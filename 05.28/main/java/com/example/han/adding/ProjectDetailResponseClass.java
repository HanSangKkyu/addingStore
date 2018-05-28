package com.example.han.adding;

public class ProjectDetailResponseClass {
    int pnum;
    String pname;
    String introduction;
    String category;
    String deadline;
    int fundgoal;
    int current;
    String image;
    String admin;

    boolean state;
    String str;

    public ProjectDetailResponseClass(int pnum, String pname, String introduction, String category, String deadline, int fundgoal, int current, String image, String admin) {
        this.pnum = pnum;
        this.pname = pname;
        this.introduction = introduction;
        this.category = category;
        this.deadline = deadline;
        this.fundgoal = fundgoal;
        this.current = current;
        this.image = image;
        this.admin = admin;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getFundgoal() {
        return fundgoal;
    }

    public void setFundgoal(int fundgoal) {
        this.fundgoal = fundgoal;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
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
