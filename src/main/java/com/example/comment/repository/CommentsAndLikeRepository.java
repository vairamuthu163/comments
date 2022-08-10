package com.example.comment.repository;

import com.example.comment.document.CommentsAndLike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsAndLikeRepository extends MongoRepository<CommentsAndLike,String> {

}
