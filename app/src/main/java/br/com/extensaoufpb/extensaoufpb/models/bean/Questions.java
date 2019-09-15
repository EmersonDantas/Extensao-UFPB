package br.com.extensaoufpb.extensaoufpb.models.bean;

import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.AnswerText;

public class Questions {

    private String question;
    private String type;
    private Answer answer;

    public Questions(String question, String type) {
        this.question = question;
        this.type = type;
        this.answer = new AnswerText();
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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
