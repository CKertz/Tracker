package com.cooper.tracker.project;

import versionControl.Branch;

import java.time.LocalDate;

public class ProjectHelper {
    private Project project;
    private Branch branch;

    public void updateProject(Project project, String commitMessage){

        //choose if update is new branch or not, maybe implement a branch class with name, branch version
        //if not branch, just increment version
        //update commit message
        project.setRevisionNote(commitMessage);
        project.setVersionNumber(project.getVersionNumber()+1);
        project.setLastUpdated(LocalDate.now());


    }
    public void updateProject(Project project, String commitMessage, Branch branch){

        updateProject(project,commitMessage);
        branch.setBranchVersion(branch.getBranchVersion()+1);

    }
}
