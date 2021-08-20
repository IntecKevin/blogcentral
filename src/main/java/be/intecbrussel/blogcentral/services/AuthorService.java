package be.intecbrussel.blogcentral.services;

import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepo authorRepository;

    public AuthorService(AuthorRepo authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void deleteMyAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
