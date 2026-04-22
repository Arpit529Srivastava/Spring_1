package com.movie.recommendation.strategy;

import org.springframework.stereotype.Component;
import java.util.List;

@Component("contextBased")
public class ContextBasedStrategy implements RecommendationStrategy {

    @Override
    public List<String> recommend(String userId) {
        return List.of(
            "The Matrix",
            "Avatar",
            "Dune"
        );
    }
}
