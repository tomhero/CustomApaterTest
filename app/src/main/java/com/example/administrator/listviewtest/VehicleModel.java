package com.example.administrator.listviewtest;

import java.io.Serializable;

/**
 * Created by Administrator on 30/9/2559.
 * This is Model Class for contain data
 * Q : Why do we implement Serializable here?
 * A : Because VehicleModel object is sent via intent to other activities
 */

class VehicleModel implements Serializable{

    private String header, content;
    private int imageId;

    VehicleModel(String header, String content, int imageId) {
        this.header = header;
        this.content = content;
        this.imageId = imageId;
    }

    VehicleModel(String header, String content) {
        this.header = header;
        this.content = content;
    }

    // getter and setter below

    String getHeader() {
        return header;
    }

    void setHeader(String header) {
        this.header = header;
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    int getImageId() {
        return imageId;
    }

    void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
