package com.example.comment.document;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    private String userId;
    private String commentedUserId;
    private String text;
    private List<Comment> comment=new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentedUserId() {
        return commentedUserId;
    }

    public void setCommentedUserId(String commentedUserId) {
        this.commentedUserId = commentedUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userId='" + userId + '\'' +
                ", commentedUserId='" + commentedUserId + '\'' +
                ", text='" + text + '\'' +
                ", comment=" + comment +
                '}';
    }
}
