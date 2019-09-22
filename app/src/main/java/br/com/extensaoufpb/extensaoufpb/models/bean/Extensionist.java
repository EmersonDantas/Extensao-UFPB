package br.com.extensaoufpb.extensaoufpb.models.bean;

import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.FeedbackMananger;

public class Extensionist extends User implements FeedbackMananger {
    private String course;
    private String state;

    public Extensionist(int profilePhoto, String name, String password, String email, String course, String state) {
        super(profilePhoto, name, password, email);
        this.course = course;
        this.state = state;
    }

    @Override
    public void viewSuggestions() {

    }

    @Override
    public void answerSuggestion() {

    }

    @Override
    public void viewQuestions() {

    }

    @Override
    public void answerQuestions() {

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}