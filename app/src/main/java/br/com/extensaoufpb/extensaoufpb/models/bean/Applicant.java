package br.com.extensaoufpb.extensaoufpb.models.bean;

public class Applicant {

    private int userPhoto;
    private String firstName;
    private String secondName;
    private String userCurse;
    private String cra;
    private String interestArea;
    private String qualifications;

    public Applicant(int userPhoto, String firstName, String secondName, String userCurse, String cra, String interestArea, String qualifications) {
        this.userPhoto = userPhoto;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userCurse = userCurse;
        this.cra = cra;
        this.interestArea = interestArea;
        this.qualifications = qualifications;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public String getInterestArea() {
        return interestArea;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUserCurse() {
        return userCurse;
    }

    public String getCra() {
        return cra;
    }
}