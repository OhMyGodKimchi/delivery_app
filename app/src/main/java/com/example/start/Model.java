package com.example.start;

public class Model {

    int image;
    String name1;
    String name2;
    int image2;



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public Model(int image, String name1, String name2, int image2) {
        this.image = image;
        this.name1 = name1;
        this.name2 = name2;
        this.image2 = image2;
    }
}
