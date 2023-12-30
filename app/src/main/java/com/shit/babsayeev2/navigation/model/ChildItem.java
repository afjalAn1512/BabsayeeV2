package com.shit.babsayeev2.navigation.model;

public class ChildItem {

    private String childName;

    private int imgOne;
    private int imgTwo;


    public ChildItem(String childName, int imgOne, int imgTwo) {
        this.childName = childName;
        this.imgOne = imgOne;
        this.imgTwo = imgTwo;
    }

    public ChildItem() {
    }

    public ChildItem(String childName) {
        this.childName = childName;
    }

    public ChildItem(String childName, int imgOne) {
        this.childName = childName;
        this.imgOne = imgOne;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getImgOne() {
        return imgOne;
    }

    public void setImgOne(int imgOne) {
        this.imgOne = imgOne;
    }

    public int getImgTwo() {
        return imgTwo;
    }

    public void setImgTwo(int imgTwo) {
        this.imgTwo = imgTwo;
    }
}
