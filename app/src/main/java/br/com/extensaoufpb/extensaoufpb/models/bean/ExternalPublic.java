package br.com.extensaoufpb.extensaoufpb.models.bean;

import br.com.extensaoufpb.extensaoufpb.models.bean.interfaces.IssuerOfQuestions;

public class ExternalPublic extends User implements IssuerOfQuestions {
    
    @Override
    public void sendQuestions() {

    }

    @Override
    public void sendSuggestionsNewProjects() {

    }
}
