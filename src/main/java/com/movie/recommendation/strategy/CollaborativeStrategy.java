package com.movie.recommendation.strategy;

import org.springframework.stereotype.Component;
import java.util.List;

@Component("collaborative")
public class CollaborativeStrategy implements RecommendationStrategy {

    @Override
    public List<String> recommend(String userId) {
        return List.of(
            "The Dark Knight",
            "Inception",
            "Interstellar"
        );
    }
}
