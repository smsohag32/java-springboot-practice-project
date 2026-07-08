package com.example.bookify.service;

import com.example.bookify.entity.Comment;
import com.example.bookify.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {
    public final CommentRepository commentRepository;

    public Comment createComments(Comment comment){
        return commentRepository.save(comment);
    }
    public List<Comment> getComments () {
        return commentRepository.findAll();
    }
    public Comment getCommentById (Long id) {
        return commentRepository.findById(id).orElseThrow(null);

    }

    public  Comment updateComment (Comment comment, Long id) {
        Comment dbData = commentRepository.findById(id).orElseThrow(null);
        dbData.setComment(comment.getComment());
        dbData.setCreatedBy(comment.getCreatedBy());
        return  commentRepository.save(dbData);

    }




}
