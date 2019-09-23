package br.com.extensaoufpb.extensaoufpb.models.bean;


public class Project {

    private int logo;
    private String title, date, description;
    private int postImage;

    public Project() {
        super();
    }

    public Project(int logo, String title, String date, String description, int postImage) {
        this.logo = logo;
        this.title = title;
        this.date = date;
        this.description = description;
        this.postImage = postImage;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

}