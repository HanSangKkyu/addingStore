package com.example.han.adding;

public class FundRequestClass {
    private String category;
    private String pname;
    private int start;
    private int number;

    FundRequestClass(String category, int start, int number) {
        this.category = category;
        this.start = start;
        this.number = number;
    }

    FundRequestClass() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }
}
