package br.com.extensaoufpb.extensaoufpb.models.bean;


public class Suggestion {
    private int userPhoto;
    private String suggestionTitle;
    private String date;
    private String userName;
    private String suggestionResume;
    private String suggestionText;

    public Suggestion(){

    }

    public Suggestion(int userPhoto, String suggestionTitle, String date, String userName, String suggestionResume, String suggestionText) {
        this.userPhoto = userPhoto;
        this.suggestionTitle = suggestionTitle;
        this.date = date;
        this.userName = userName;
        this.suggestionResume = suggestionResume;
        this.suggestionText = suggestionText;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public String getSuggestionTitle() {
        return suggestionTitle;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public String getDate() {
        return date;
    }

    public String getUserName() {
        return userName;
    }

    public String getSuggestionResume() {
        return suggestionResume;
    }

}
