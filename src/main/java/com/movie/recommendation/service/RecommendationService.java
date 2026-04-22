package com.movie.recommendation.service;

import com.movie.recommendation.strategy.RecommendationStrategy;

import java.util.List;

public class RecommendationService {

    private final RecommendationStrategy strategy;

    public RecommendationService(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> getRecommendations(String userId) {
        return strategy.recommend(userId);
    }
}
