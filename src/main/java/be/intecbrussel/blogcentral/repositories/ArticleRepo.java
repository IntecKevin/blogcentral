package be.intecbrussel.blogcentral.repositories;

import be.intecbrussel.blogcentral.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepo extends JpaRepository <Article, Long> {
    @Query("SELECT u FROM Article u WHERE u.id = ?1")
    public Optional<Article> findById(Long id);
}
