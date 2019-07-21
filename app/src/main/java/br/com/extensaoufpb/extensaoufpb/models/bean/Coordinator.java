package br.com.extensaoufpb.extensaoufpb.models.bean;

import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.FeedbackMananger;

public class Coordinator extends User implements FeedbackMananger {


    public void registerProject(){}

    public void disclosureProjectSelectionProcess(){}

    public void viewAllProjects(){}

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