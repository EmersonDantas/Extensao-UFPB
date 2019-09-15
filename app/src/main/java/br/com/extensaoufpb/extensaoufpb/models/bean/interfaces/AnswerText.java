package br.com.extensaoufpb.extensaoufpb.models.bean.interfaces;

import br.com.extensaoufpb.extensaoufpb.models.bean.Answer;

public class AnswerText implements Answer {

    private String answer;

    public AnswerText() {
        answer = "";
    }

    public AnswerText(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
