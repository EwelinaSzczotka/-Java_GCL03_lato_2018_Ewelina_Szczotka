package com.example.springboot;


public class Image {
    
    private int index;
    private String name;
    private String resolution;
    private long size;
    private long created;

    public Image() {
       
    }

    public Image(int index, String name, String resolution, long size) {
        this.index = index;
        this.name = name;
        this.resolution = resolution;
        this.size = size;
        this.created = System.currentTimeMillis();
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getResolution() {
        return resolution;
    }

    public long getSize() {
        return size;
    }

    public long getCreated() {
        return created;
    }
    
    
    
    
}
