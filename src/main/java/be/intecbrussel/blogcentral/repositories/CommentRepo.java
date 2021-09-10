package be.intecbrussel.blogcentral.repositories;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Query("SELECT u FROM Comment u WHERE u.id = ?1")
    public Optional<Comment> findById(Long id);
}
