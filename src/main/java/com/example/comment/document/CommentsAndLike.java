package com.example.comment.document;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class CommentsAndLike {
    @Id
    private String id;//post id
    private String userId;
    private Integer likesCount=0;
    private Integer dislikesCount=0;
    private List<UserLike> userReaction=new ArrayList<>();
    private List<Comment> comments=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getDislikesCount() {
        return dislikesCount;
    }

    public void setDislikesCount(Integer dislikesCount) {
        this.dislikesCount = dislikesCount;
    }

    public List<UserLike> getUserReaction() {
        return userReaction;
    }

    public void setUserReaction(List<UserLike> userReaction) {
        this.userReaction = userReaction;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
