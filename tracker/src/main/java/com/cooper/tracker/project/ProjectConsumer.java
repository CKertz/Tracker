package com.cooper.tracker.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class ProjectConsumer {
    private final String ProjectGetURI ="http://localhost:8080";
    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping("/api/v1/project")
    public Project[] getProjects()
    {
        try{
            WebClient webClient = WebClient.create("http://localhost:8080");
            Project[] result = webClient.get()
                        .uri("/api/v1/project")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(Project[].class)
                        .block();
            //webClientBuilder.baseUrl("http://localhost:8080");
            //builder.baseUrl("http://localhost:8080").build();
            //return builder.build().get().uri(ProjectGetURI).retrieve().bodyToMono(Project[].class).block();
//            Project res = webClientBuilder.build()
//                    .get()
//                    .uri("/api/v1/project")
//                    .retrieve()
//                    .bodyToMono(Project.class)
//                    .block();
            return result;

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
