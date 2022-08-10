package com.example.comment.controller;

import com.example.comment.document.CommentsAndLike;
import com.example.comment.dto.CommentDto;
import com.example.comment.dto.LikeDto;
import com.example.comment.service.CommentsAndLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/post")
@CrossOrigin(value = "*")
public class CommentsAndLikeController {

    @Autowired
    CommentsAndLikeService commentsAndLikeService;


    @PostMapping("/add-comment")
    public CommentsAndLike addComment(@RequestBody CommentDto commentDto){
        return commentsAndLikeService.addComment(commentDto);
    }

    @DeleteMapping("/delete-comment/{postId}/{id}")
    public CommentsAndLike removeComment(@PathVariable("postId") String postId, @PathVariable("id") String id){
        return commentsAndLikeService.deleteComment(postId,id);
    }

    @GetMapping("/add/{userId}/{id}")
    public void addDoc(@PathVariable("userId") String userId,@PathVariable("id") String id){
        commentsAndLikeService.addDoc(userId,id);
    }

    @PostMapping("/add-nested-comment")
    public CommentsAndLike addNested(@RequestBody CommentDto commentDto){
        return commentsAndLikeService.addNestedComment(commentDto);
    }

    @DeleteMapping("/delete-nested-comment/{postId}/{id}")
    public CommentsAndLike removeNestedComment(@PathVariable("postId") String postId,@PathVariable("id") String id){
        return commentsAndLikeService.deleteNestedComment(postId,id);
    }

    @PostMapping("/add-like")
    public CommentsAndLike addLike(@RequestBody LikeDto likeDto){
        return commentsAndLikeService.addlike(likeDto);
    }

    @PostMapping("/add-dislike")
    public CommentsAndLike addDislike(@RequestBody LikeDto likeDto){
        return  commentsAndLikeService.addDislike(likeDto);
    }

    @GetMapping("/get-all")
    public List<CommentsAndLike> getAll(){
        return commentsAndLikeService.getAll();
    }

    @GetMapping("/get-reactions/{id}")
    public CommentsAndLike getLikes(@PathVariable("id") String id){
        return commentsAndLikeService.getLikesCount(id);
    }
}
