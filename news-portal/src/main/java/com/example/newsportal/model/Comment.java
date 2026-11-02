package com.example.newsportal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String readerName;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "news_id", nullable = false)
    private News news;

    public Comment() {}

    public Comment(String readerName, String content, LocalDateTime createdAt) {
        this.readerName = readerName;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getReaderName() { return readerName; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public News getNews() { return news; }
    public void setNews(News news) { this.news = news; }
}
