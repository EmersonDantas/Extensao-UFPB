package br.com.extensaoufpb.extensaoufpb.models.bean;

public class Answer {

    private int id;
    private String tipo;
    private String answerQuestion;
    private int idAnswer;
    private String amountCharacter;
    private String number;

    public Answer(String answerQuestion) {
        this.id = 0;
        this.tipo = "";
        this.answerQuestion = answerQuestion;
        this.idAnswer = 0;
        this.amountCharacter = "";
        this.number = "";
    }

    public Answer() {

        this.id = 0;
        this.tipo ="";
        this.answerQuestion = "";
        this.idAnswer = 0;
        this.amountCharacter = "";
        this.number = "";

    }

    public String getAmountCharacter() {
        return amountCharacter;
    }

    public void setAmountCharacter(String amountCharacter) {
        this.amountCharacter = amountCharacter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(String answerQuestion) {
        this.answerQuestion = answerQuestion;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", answerQuestion='" + answerQuestion + '\'' +
                ", idAnswer=" + idAnswer +
                '}';
    }
}
