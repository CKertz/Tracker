package com.cooper.tracker.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profRepository){this.profileRepository = profRepository;}

    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public void addNewProfile(Profile profile){
        Optional<Profile> profileOptional = profileRepository.findProfileByName(profile.getProfileName());
        if(profileOptional.isPresent()){
            throw new IllegalStateException("profile does not have unique name");
        }
        profileRepository.save(profile);

    }

    public void deleteSong(Long profileId) {
        boolean exists = profileRepository.existsById(profileId);
        if(!exists) {
            throw new IllegalStateException("profile with id " + profileId + " does not exist");
        }
        profileRepository.deleteById(profileId);
    }

}
