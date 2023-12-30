package com.shit.babsayeev2.navigation.model;

import java.util.ArrayList;
import java.util.List;

public class GroupItem {

    private String groupName;
    private int imgOne;
    private int imgTwo;

    List<ChildItem> childModelList = new ArrayList<>();

    public GroupItem(String groupName, int imgOne, int imgTwo) {
        this.groupName = groupName;
        this.imgOne = imgOne;
        this.imgTwo = imgTwo;
    }


    public GroupItem(String groupName, int imgOne) {
        this.groupName = groupName;
        this.imgOne = imgOne;
    }

    public GroupItem(String groupName, int imgOne, int imgTwo, List<ChildItem> childModelList) {
        this.groupName = groupName;
        this.imgOne = imgOne;
        this.imgTwo = imgTwo;
        this.childModelList = childModelList;
    }

    public GroupItem(String groupName, int imgOne, List<ChildItem> childModelList) {
        this.groupName = groupName;
        this.imgOne = imgOne;
        this.childModelList = childModelList;
    }

    public GroupItem() {
    }

    public GroupItem(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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


    public List<ChildItem> getChildModelList() {
        return childModelList;
    }

    public void setChildModelList(List<ChildItem> childModelList) {
        this.childModelList = childModelList;
    }
}
