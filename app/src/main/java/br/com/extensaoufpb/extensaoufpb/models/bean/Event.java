package br.com.extensaoufpb.extensaoufpb.models.bean;

public class Event {
    private int image;
    private String title;
    private String desciption;
    private String data;
    private String duration;
    private String locate;
    private String room;
    private String cHorary;
    private boolean certify;

    public Event(int image, String title, String desciption, String data, String duration, String locate, String room, String cHorary, boolean certify) {
        this.image = image;
        this.title = title;
        this.desciption = desciption;
        this.data = data;
        this.duration = duration;
        this.locate = locate;
        this.room = room;
        this.cHorary = cHorary;
        this.certify = certify;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getcHorary() {
        return cHorary;
    }

    public void setcHorary(String cHorary) {
        this.cHorary = cHorary;
    }

    public boolean isCertify() {
        return certify;
    }

    public void setCertify(boolean certify) {
        this.certify = certify;
    }
}
