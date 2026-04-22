package com.movie.recommendation;

import com.movie.recommendation.config.AppConfig;
import com.movie.recommendation.service.RecommendationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MovieApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        String userId = "user123";

        // Collaborative Filtering
        RecommendationService collaborativeService =
                context.getBean("collaborativeService", RecommendationService.class);
        List<String> collabMovies = collaborativeService.getRecommendations(userId);
        System.out.println("Collaborative Strategy Recommendations:");
        collabMovies.forEach(m -> System.out.println("  - " + m));

        // Context Based
        RecommendationService contextBasedService =
                context.getBean("contextBasedService", RecommendationService.class);
        List<String> contextMovies = contextBasedService.getRecommendations(userId);
        System.out.println("\nContext-Based Strategy Recommendations:");
        contextMovies.forEach(m -> System.out.println("  - " + m));

        // Content Based
        RecommendationService contentBasedService =
                context.getBean("contentBasedService", RecommendationService.class);
        List<String> contentMovies = contentBasedService.getRecommendations(userId);
        System.out.println("\nContent-Based Strategy Recommendations:");
        contentMovies.forEach(m -> System.out.println("  - " + m));

        context.close();
    }
}
