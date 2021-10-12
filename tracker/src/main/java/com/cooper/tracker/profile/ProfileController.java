package com.cooper.tracker.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService projectService) {this.profileService = projectService;}

    @GetMapping
    public List<Profile> getProfile(){
        return profileService.getProfiles();
    }

    @PostMapping
    public void registerNewProfile(@RequestBody Profile profile){profileService.addNewProfile(profile);}

    @DeleteMapping(path = "{projectId}")
    public void deleteProfile(@PathVariable("profileId") Long profileId) {profileService.deleteSong(profileId);}
}
