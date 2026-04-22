package com.movie.recommendation.strategy;

import java.util.List;

public interface RecommendationStrategy {
    List<String> recommend(String userId);
}
