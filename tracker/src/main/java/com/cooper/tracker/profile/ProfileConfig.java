package com.cooper.tracker.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.AUGUST;
import static java.time.Month.MAY;

@Configuration
public class ProfileConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository repository){
        return args -> {
            Profile firstProfile = new Profile(
                    "Cooper",
                    "kertzc@live.com",
                    "CoopersBand"
            );

            Profile secondProfile = new Profile(
                    "Bob",
                    "Bob@gmail.com",
                    "CoopersBand"
            );


            repository.saveAll(List.of(firstProfile,secondProfile));
        };
    }
}
