package cz.educanet;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PostRepository {
    public List<Post> getPosts() throws SQLException {

        ArrayList<Post> posts = new ArrayList<>();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/facebook?user=root&password=");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT p.post_id, p.content, p.author, p.likes, p.dislikes, p.created_at, p.updated_at" +
                        " FROM facebook.posts AS p"
        );

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            posts.add(new Post(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();

        return posts;
    }

    public void addPost(String content, String author) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/facebook?user=root&password=");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO facebook.posts (content, author, likes, dislikes, created_at, updated_at)" +
                        " VALUES (?, ?, 0, 0, NOW(), NOW())"
        );

        preparedStatement.setString(1, content);
        preparedStatement.setString(2, author);

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();
    }

    public void deletePost(int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/facebook?user=root&password=");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM facebook.posts WHERE post_id = ?"
        );

        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();
    }
}
