package com.example.newsportal.controller;

import com.example.newsportal.model.Comment;
import com.example.newsportal.model.News;
import com.example.newsportal.repository.CategoryRepository;
import com.example.newsportal.repository.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
public class NewsController {
    private final CategoryRepository categoryRepository;
    private final NewsRepository newsRepository;

    public NewsController(CategoryRepository categoryRepository, NewsRepository newsRepository) {
        this.categoryRepository = categoryRepository;
        this.newsRepository = newsRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/category/{id}")
    public String categoryNews(@PathVariable Long id, Model model) {
        var category = categoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        model.addAttribute("category", category);
        model.addAttribute("newsItems",
            newsRepository.findDistinctByCategories_IdOrderByPublishedAtDesc(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";
    }

    @GetMapping("/news/{id}")
    public String newsDetails(@PathVariable Long id, Model model) {
        News news = newsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("News not found"));
        model.addAttribute("news", news);
        return "news-details";
    }

    @PostMapping("/news/{id}/comments")
    public String addComment(@PathVariable Long id,
                             @RequestParam String readerName,
                             @RequestParam String content,
                             RedirectAttributes redirectAttributes) {
        String cleanName = readerName == null ? "" : readerName.trim();
        String cleanContent = content == null ? "" : content.trim();

        if (cleanName.isEmpty() || cleanName.length() > 80 ||
            cleanContent.isEmpty() || cleanContent.length() > 1000) {
            redirectAttributes.addFlashAttribute("error",
                "Please enter your name (up to 80 characters) and a comment (up to 1000 characters).");
            return "redirect:/news/" + id;
        }

        News news = newsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("News not found"));
        news.addComment(new Comment(cleanName, cleanContent, LocalDateTime.now()));
        newsRepository.save(news);

        redirectAttributes.addFlashAttribute("success", "Your comment was added.");
        return "redirect:/news/" + id;
    }
}
