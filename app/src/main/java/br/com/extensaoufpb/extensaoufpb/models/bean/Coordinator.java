package br.com.extensaoufpb.extensaoufpb.models.bean;

import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.FeedbackMananger;

public class Coordinator extends User implements FeedbackMananger {


    public Coordinator(int profilePhoto, String name, String password, String email) {
        super(profilePhoto, name, password, email);
    }

    public void registerProject(){}

    public void disclosureProjectSelectionProcess(){}

    public void editMyProject(){}

    public void viewCandidatesEnrolledInSelection(){}

    public void viewCandidateQualifications(){}

    public void viewProjectParticipants(){}

    public void registerActivityOrEvent(){}


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

}