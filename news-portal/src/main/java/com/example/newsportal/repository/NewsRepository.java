package com.example.newsportal.repository;

import com.example.newsportal.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findDistinctByCategories_IdOrderByPublishedAtDesc(Long categoryId);
}
