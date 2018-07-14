package com.thedevwolf.hambriento.Model;

public class NavigationMenuModel {
    String title;
    int imageId;

    public NavigationMenuModel(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public NavigationMenuModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
