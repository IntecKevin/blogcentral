package be.intecbrussel.blogcentral.services;

import be.intecbrussel.blogcentral.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
