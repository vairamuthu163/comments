package com.example.comment.service.impl;

import com.example.comment.document.*;
import com.example.comment.dto.CommentDto;
import com.example.comment.dto.LikeDto;
import com.example.comment.repository.CommentsAndLikeRepository;
import com.example.comment.service.CommentsAndLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class CommentsAndLikeServiceImpl implements CommentsAndLikeService {
    @Autowired
    CommentsAndLikeRepository commentsAndLikeRepository;

    @Override
    public CommentsAndLike addComment(CommentDto commentDto) {
        // todo : this logic needs to change to using inplace add to list .. we should not load Comments object at all
        CommentsAndLike commentsAndLike = commentsAndLikeRepository.findById(commentDto.getPostId()).get();

        Comment comment = new Comment();
        comment.setUserId(commentDto.getParentUserId());
        comment.setCommentedUserId(commentDto.getCommentedUserId());
        comment.setText(commentDto.getText());

        commentsAndLike.getComments().add(comment);

        return commentsAndLikeRepository.save(commentsAndLike);
    }

    @Override
    public void addDoc(String userId,String id){
        CommentsAndLike commentsAndLike = new CommentsAndLike();
        commentsAndLike.setId(id);
        commentsAndLike.setUserId(userId);
        commentsAndLikeRepository.save(commentsAndLike);
    }

    @Override
    public CommentsAndLike addNestedComment(CommentDto commentDto) {
        CommentsAndLike commentsAndLike = commentsAndLikeRepository.findById(commentDto.getPostId()).get();

        Comment comment = new Comment();
        comment.setUserId(commentDto.getParentUserId());
        comment.setCommentedUserId(commentDto.getCommentedUserId());
        comment.setText(commentDto.getText());

        for(Comment com:commentsAndLike.getComments()){
            if(com.getUserId().equals(commentDto.getParentUserId())){
                com.getComment().add(comment);
            }
        }
        return commentsAndLikeRepository.save(commentsAndLike);
    }

    @Override
    public CommentsAndLike deleteComment(String postId,String commentedUserId) {
        CommentsAndLike commentsAndLike = commentsAndLikeRepository.findById(postId).get();
        Comment comment=null;
        for(Comment com:commentsAndLike.getComments()){
            if(com.getCommentedUserId().equals(commentedUserId)){
                comment = com;
            }
        }
        if(comment!=null){
            commentsAndLike.getComments().remove(comment);
        }
        return commentsAndLikeRepository.save(commentsAndLike);
    }

    @Override
    public CommentsAndLike deleteNestedComment(String postId, String commentedUserId) {
        CommentsAndLike comments = commentsAndLikeRepository.findById(postId).get();

        for(Comment com:comments.getComments()){
            Iterator<Comment> itr = com.getComment().iterator();
            int j=0;
            while(itr.hasNext()){
                Comment com1 = itr.next();
                if(com1.getCommentedUserId().equals(commentedUserId)){
                    com.getComment().remove(com1);
                    j=1;
                }
            }
            if(j==1){
                System.out.println("removed");
                break;
            }
        }


        return commentsAndLikeRepository.save(comments);

    }

    @Override
    public List<CommentsAndLike> getAllComments() {
        return commentsAndLikeRepository.findAll();
    }


    @Override
    public CommentsAndLike addlike(LikeDto likeDto) {
        CommentsAndLike checkLike = commentsAndLikeRepository.findById(likeDto.getId()).get();

        System.out.println(likeDto);
        if(!likeDto.getStatus().equals("like")){
            checkLike.setLikesCount(checkLike.getLikesCount() - 1);
//
            UserLike userLike = new UserLike();
            userLike.setId(likeDto.getUserId());
            userLike.setStatus("like");
            System.out.println(checkLike.getUserReaction());
            checkLike.getUserReaction().remove(userLike);
            System.out.println(checkLike.getUserReaction());
        }
        else{
            checkLike.setId(likeDto.getId());

            checkLike.setLikesCount(checkLike.getLikesCount()+1);

            UserLike userLike = new UserLike();
            userLike.setId(likeDto.getUserId());
            userLike.setStatus("like");
            if(!checkLike.getUserReaction().contains(userLike.getId())){
                checkLike.getUserReaction().add(userLike);
            }

        }
        return commentsAndLikeRepository.save(checkLike);
    }

    @Override
    public CommentsAndLike addDislike(LikeDto likeDto) {
        CommentsAndLike checkLike = commentsAndLikeRepository.findById(likeDto.getId()).get();

        System.out.println(likeDto);
        if(!likeDto.getStatus().equals("dislike")){
            checkLike.setDislikesCount(checkLike.getDislikesCount() -1);
//
            UserLike userLike = new UserLike();
            userLike.setId(likeDto.getUserId());
            userLike.setStatus("dislike");
            System.out.println(checkLike.getUserReaction());
            checkLike.getUserReaction().remove(userLike);
            System.out.println(checkLike.getUserReaction());
        }
        else{
            checkLike.setId(likeDto.getId());

            checkLike.setDislikesCount(checkLike.getDislikesCount()+1);

            UserLike userLike = new UserLike();
            userLike.setId(likeDto.getUserId());
            userLike.setStatus("dislike");
            if(!checkLike.getUserReaction().contains(userLike)){
                checkLike.getUserReaction().add(userLike);
            }
        }
        return commentsAndLikeRepository.save(checkLike);
    }

    @Override
    public List<CommentsAndLike> getAll() {
        return commentsAndLikeRepository.findAll();
    }

    @Override
    public CommentsAndLike getLikesCount(String id) {
        return commentsAndLikeRepository.findById(id).get();
    }


}
