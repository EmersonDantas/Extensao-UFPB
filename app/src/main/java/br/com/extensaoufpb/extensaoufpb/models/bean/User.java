package br.com.extensaoufpb.extensaoufpb.models.bean;

import android.widget.ImageView;

public abstract class User {

    private int profilePhoto;
    private String name;
    private String password;
    private String email;

    public User(int profilePhoto, String name, String password, String email) {
        this.profilePhoto = profilePhoto;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void login(){

    }

    public void logout(){

    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
