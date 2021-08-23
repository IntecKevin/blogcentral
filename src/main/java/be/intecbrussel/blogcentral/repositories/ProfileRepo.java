package be.intecbrussel.blogcentral.repositories;

import be.intecbrussel.blogcentral.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Author, Long> {
    @Query("SELECT u FROM Author u WHERE u.id = ?1")
    public Optional<Author> findById(Long id);

}
