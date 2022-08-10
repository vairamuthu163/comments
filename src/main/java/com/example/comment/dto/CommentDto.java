package com.example.comment.dto;

public class CommentDto {
    private String postId;
    private String parentUserId;
    private String commentedUserId;
    private String text;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
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

    @Override
    public String toString() {
        return "CommentDto{" +
                "postId=" + postId +
                ", parentUserId='" + parentUserId + '\'' +
                ", commentedUserId='" + commentedUserId + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
