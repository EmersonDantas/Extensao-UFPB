package br.com.extensaoufpb.extensaoufpb.models.bean;

import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.IssuerOfQuestions;

public class InternalPublic extends User implements IssuerOfQuestions {

    public InternalPublic(int profilePhoto, String name, String password, String email) {
        super(profilePhoto, name, password, email);
    }

    @Override
    public void sendQuestions() {

    }

    @Override
    public void sendSuggestionsNewProjects() {

    }

}