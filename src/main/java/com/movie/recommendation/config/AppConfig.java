package com.movie.recommendation.config;

import com.movie.recommendation.service.RecommendationService;
import com.movie.recommendation.strategy.RecommendationStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.movie.recommendation")
public class AppConfig {

    @Bean("collaborativeService")
    public RecommendationService collaborativeRecommendationService(
            @Qualifier("collaborative") RecommendationStrategy strategy) {
        return new RecommendationService(strategy);
    }

    @Bean("contextBasedService")
    public RecommendationService contextBasedRecommendationService(
            @Qualifier("contextBased") RecommendationStrategy strategy) {
        return new RecommendationService(strategy);
    }

    @Bean("contentBasedService")
    public RecommendationService contentBasedRecommendationService(
            @Qualifier("contentBased") RecommendationStrategy strategy) {
        return new RecommendationService(strategy);
    }
}
