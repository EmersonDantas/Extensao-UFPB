package br.com.extensaoufpb.extensaoufpb.models.bean;

import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.IssuerOfQuestions;

public class ExternalPublic extends User implements IssuerOfQuestions {

    public ExternalPublic(int profilePhoto, String name, String password, String email) {
        super(profilePhoto, name, password, email);
    }

    @Override
    public void sendQuestions() {

    }

    @Override
    public void sendSuggestionsNewProjects() {

    }
}
