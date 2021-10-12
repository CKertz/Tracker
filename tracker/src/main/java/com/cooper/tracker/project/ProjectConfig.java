package com.cooper.tracker.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class ProjectConfig {
    @Bean
    CommandLineRunner projectCommandLineRunner(ProjectRepository repository){
        return args -> {
            Project firstTrack = new Project(
                    "first track",
                    "this is my first demo, it sucks.",
                    "butt rock",
                    LocalDate.of(2017, AUGUST, 4),
                    LocalDate.of(2021, MAY, 24),
                    "Cooper Kertz",
                    "added a lil geetar",
                    false,
                    1
                    );

            Project secondTrack = new Project(
                    "second track",
                    "this is my second demo, it sucks slightly less than the first one.",
                    "ska but with banjo",
                    LocalDate.of(2018, AUGUST, 4),
                    LocalDate.of(2021, MAY, 25),
                    "Cooper Kertz",
                    "added a lil banjo",
                    false,
                    1
            );

            repository.saveAll(List.of(firstTrack,secondTrack));
        };
    }
}
