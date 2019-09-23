package br.com.extensaoufpb.extensaoufpb.models.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {

    private String question;
    private String type;
    private List<Answer> answers;

    public Question() {
        this.question = "";
        this.type = "";
        this.answers = new ArrayList<>();
    }

    public Question(String question, String type) {
        this.question = question;
        this.type = type;
        this.answers = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswer() {
        return answers;
    }

    public void setAnswer(List<Answer> answers) {

        this.answers = answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
