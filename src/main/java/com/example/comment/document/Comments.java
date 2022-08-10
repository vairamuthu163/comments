package com.example.comment.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

// todo : missing the postId and userId association in this table.. need to fix that first
@Document
public class Comments {

    @Id
    private int id;
    private List<Comment> comments=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comments=" + comments +
                '}';
    }
}
