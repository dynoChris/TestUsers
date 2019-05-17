package com.oliverstudio.testusers.data.models;

public class User {

    private String name;
    private String photoUrl;
    private String email;
    private int age;
    private String city;

    public User(String name, String photoUrl, String email, int age, String city) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.email = email;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
