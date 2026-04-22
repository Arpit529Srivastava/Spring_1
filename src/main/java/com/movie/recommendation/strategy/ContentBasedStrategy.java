package com.movie.recommendation.strategy;

import org.springframework.stereotype.Component;
import java.util.List;

@Component("contentBased")
public class ContentBasedStrategy implements RecommendationStrategy {

    @Override
    public List<String> recommend(String userId) {
        return List.of(
            "The Godfather",
            "Pulp Fiction",
            "Fight Club"
        );
    }
}
