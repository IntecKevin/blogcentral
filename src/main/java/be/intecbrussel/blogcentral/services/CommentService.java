package be.intecbrussel.blogcentral.services;

import be.intecbrussel.blogcentral.model.Comment;

import java.util.List;

public interface CommentService {

    Comment findById(Long id);

    Comment saveComment(Long postId, Long userId);

    List<Comment> findAll();

    void deleteById(Long commentId);
}

