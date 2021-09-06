package be.intecbrussel.blogcentral.repositories;

import be.intecbrussel.blogcentral.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("SELECT u FROM Author u WHERE u.email = ?1")
    public Author findByEmail(String email);
}
