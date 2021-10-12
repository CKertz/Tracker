package com.cooper.tracker.profile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Profile
{
    @Id
    @SequenceGenerator(
            name="profile_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_sequence"
    )
    private Long ID;
    private String profileName;
    private String emailAddress;
    private String groupName;

    public Profile(){
    }

    public Profile(Long ID, String profileName, String emailAddress, String groupName) {
        this.ID = ID;
        this.profileName = profileName;
        this.emailAddress = emailAddress;
        this.groupName = groupName;
    }

    public Profile(String profileName, String emailAddress, String groupName) {
        this.profileName = profileName;
        this.emailAddress = emailAddress;
        this.groupName = groupName;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
