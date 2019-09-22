package br.com.extensaoufpb.extensaoufpb.models.bean;

public class ProcessSelection {
    private int projectLogo;
    private String projectName;
    private String projectArea;
    private String opportunitys;


    public ProcessSelection(){

    }

    public ProcessSelection(int projectLogo, String projectName, String projectArea, String opportunitys) {
        this.projectLogo = projectLogo;
        this.projectName = projectName;
        this.projectArea = projectArea;
        this.opportunitys = opportunitys;
    }

    public int getProjectLogo() {
        return projectLogo;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectArea() {
        return projectArea;
    }

    public String getOpportunitys() {
        return opportunitys;
    }
}
