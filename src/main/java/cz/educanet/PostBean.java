package cz.educanet;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.util.List;

@Named
@RequestScoped
public class PostBean {

    private final PostRepository postRepository = new PostRepository();

    private String content = "";
    private String author = "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Post> getPosts() throws SQLException {
        return postRepository.getPosts();
    }

    public void addPost() throws SQLException {
        if (this.content.equals("") || this.author.equals("")) return;
        System.out.println(this.content);
        System.out.println(this.author);
        postRepository.addPost(this.content, this.author);
    }

    public void deletePost(int id) throws SQLException {
        postRepository.deletePost(id);
    }
}
