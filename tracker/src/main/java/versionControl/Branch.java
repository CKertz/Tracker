package versionControl;

import com.cooper.tracker.project.Project;

public class Branch {
    private String branchName;
    private double branchVersion;
    private Project project;


    public Branch() {
    }

    public Branch(String branchName, double branchVersion, Project project) {
        this.branchName = branchName;
        this.branchVersion = branchVersion;
        this.project = project;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public double getBranchVersion() {
        return branchVersion;
    }

    public void setBranchVersion(double branchVersion) {
        this.branchVersion = branchVersion;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
