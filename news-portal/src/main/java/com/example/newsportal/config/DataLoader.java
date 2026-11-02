package com.example.newsportal.config;

import com.example.newsportal.model.Category;
import com.example.newsportal.model.News;
import com.example.newsportal.repository.CategoryRepository;
import com.example.newsportal.repository.NewsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Set;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadSampleData(CategoryRepository categoryRepository,
                                     NewsRepository newsRepository) {
        return args -> {
            if (categoryRepository.count() > 0) return;

            Category sports = categoryRepository.save(
                new Category("Sports", "Cricket, football and other sports"));
            Category entertainment = categoryRepository.save(
                new Category("Entertainment", "Movies, music and culture"));
            Category technology = categoryRepository.save(
                new Category("Technology", "Technology and innovation"));
            Category politics = categoryRepository.save(
                new Category("Politics", "Local and international politics"));

            News n1 = new News(
                "Sri Lanka celebrates a thrilling cricket victory",
                "Sri Lanka delivered an exciting performance in a closely contested cricket match. " +
                "The team showed determination throughout the game, while supporters celebrated the result. " +
                "This is sample article content for the news portal demonstration.",
                LocalDateTime.now().minusHours(2));
            n1.setCategories(Set.of(sports));
            newsRepository.save(n1);

            News n2 = new News(
                "New film festival announced in Colombo",
                "Organizers have announced a film festival featuring local and international productions. " +
                "The event aims to celebrate storytelling, creativity and the local film industry.",
                LocalDateTime.now().minusDays(1));
            n2.setCategories(Set.of(entertainment));
            newsRepository.save(n2);

            News n3 = new News(
                "Cricket documentary to premiere this month",
                "A new documentary exploring the history of Sri Lankan cricket is scheduled to premiere this month. " +
                "The production combines sporting moments with interviews and behind-the-scenes stories.",
                LocalDateTime.now().minusDays(2));
            n3.setCategories(Set.of(sports, entertainment));
            newsRepository.save(n3);

            News n4 = new News(
                "Technology startups explore new AI applications",
                "Technology companies are exploring practical applications of artificial intelligence in education, " +
                "business and public services. This article is sample content for the demonstration.",
                LocalDateTime.now().minusDays(3));
            n4.setCategories(Set.of(technology));
            newsRepository.save(n4);

            News n5 = new News(
                "Parliament discusses new policy proposals",
                "Lawmakers discussed a series of policy proposals during the latest parliamentary session. " +
                "Further details are expected after the relevant committees review the proposals.",
                LocalDateTime.now().minusDays(4));
            n5.setCategories(Set.of(politics));
            newsRepository.save(n5);
        };
    }
}
