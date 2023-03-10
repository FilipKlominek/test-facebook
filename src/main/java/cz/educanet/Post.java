package cz.educanet;

import java.time.LocalDateTime;

public class Post {
    private final int id;
    private String content;
    private final String author;
    private int likes;
    private int dislikes;
    private final String createdAt;
    private String updatedAt;

    public Post(int id, String content, String author, int likes, int dislikes, String createdAt, String updatedAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = likes;
        this.dislikes = dislikes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void like() {
        this.likes++;
    }

    public void dislike() {
        this.dislikes++;
    }

    public void edit(String content) {
        this.updatedAt = LocalDateTime.now().toString();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
