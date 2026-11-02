package com.zehranur.egemuzerehberi;

public class Museum {
    private String name;
    private String location;
    private int imageResId; // Müze görseli için

    public Museum(String name, String location, int imageResId) {
        this.name = name;
        this.location = location;
        this.imageResId = imageResId;
    }

    // Getter metotları (Bunlar veriyi çekmemizi sağlar)
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getImageResId() { return imageResId; }
}