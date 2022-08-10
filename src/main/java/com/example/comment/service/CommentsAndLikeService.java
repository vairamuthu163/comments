package com.example.comment.service;

import com.example.comment.document.CommentsAndLike;
import com.example.comment.dto.CommentDto;
import com.example.comment.dto.LikeDto;

import java.util.List;

public interface CommentsAndLikeService {
    CommentsAndLike addComment(CommentDto commentDto);
    void addDoc(String userId,String id);
    CommentsAndLike addNestedComment(CommentDto commentDto);
    CommentsAndLike deleteComment(String postId, String commentedUserId);
    CommentsAndLike deleteNestedComment(String postId, String commentedUserId);
    List<CommentsAndLike> getAllComments();
    CommentsAndLike addlike(LikeDto likeDto);
    CommentsAndLike addDislike(LikeDto likeDto);
    List<CommentsAndLike> getAll();

    CommentsAndLike getLikesCount(String id);
}
