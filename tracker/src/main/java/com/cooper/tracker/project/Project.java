package com.cooper.tracker.project;

import versionControl.Branch;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Project
{
    @Id
    @SequenceGenerator(
            name="project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    private Long ID;
    private String name;
    private String trackDescription;
    private String genre;
    private LocalDate createdDate;
    private LocalDate lastUpdated;
    private String author;
    private String revisionNote;
    private boolean isFavorite;
    private int versionNumber; //update this to a double for minor versions?
   // private Branch branch;

    public Project(){
    }

    //this one is used if branching is necessary
//    public Project(Long ID, String name, String trackDescription, String genre, LocalDate createdDate, LocalDate lastUpdated,
//                   String author, String revisionNote, boolean isFavorite, int versionNumber, Branch branch) {
//        this.ID = ID;
//        this.name = name;
//        this.trackDescription = trackDescription;
//        this.genre = genre;
//        this.createdDate = createdDate;
//        this.lastUpdated = lastUpdated;
//        this.author = author;
//        this.revisionNote = revisionNote;
//        this.isFavorite = isFavorite;
//        this.versionNumber = versionNumber;
//        this.branch = branch;
//    }



    public Project(Long ID, String name, String trackDescription, String genre, LocalDate createdDate, LocalDate lastUpdated,
                   String author, String revisionNote, boolean isFavorite, int versionNumber) {
        this.ID = ID;
        this.name = name;
        this.trackDescription = trackDescription;
        this.genre = genre;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
        this.author = author;
        this.revisionNote = revisionNote;
        this.isFavorite = isFavorite;
        this.versionNumber = versionNumber;
    }

    public Project(String name, String trackDescription, String genre, LocalDate createdDate, LocalDate lastUpdated,
                   String author, String revisionNote, boolean isFavorite, int versionNumber) {
        this.name = name;
        this.trackDescription = trackDescription;
        this.genre = genre;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
        this.author = author;
        this.revisionNote = revisionNote;
        this.isFavorite = isFavorite;
        this.versionNumber = versionNumber;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackDescription() {
        return trackDescription;
    }

    public void setTrackDescription(String trackDescription) {
        this.trackDescription = trackDescription;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRevisionNote() {
        return revisionNote;
    }

    public void setRevisionNote(String revisionNote) {
        this.revisionNote = revisionNote;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

//    public Branch getBranch() {
//        return branch;
//    }
//
//    public void setBranch(Branch branch) {
//        this.branch = branch;
//    }
}
