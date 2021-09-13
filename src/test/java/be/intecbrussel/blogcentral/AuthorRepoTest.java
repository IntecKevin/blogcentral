package be.intecbrussel.blogcentral;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AuthorRepoTest {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Author author1 = new Author();
        Article article1 = new Article();
        author1.setEmail("salai2@gmail.com");
        author1.setPassword("salai2");
        author1.setFirstName("Salai2");
        author1.setLastName("Aung");
        author1.getArticles().add(article1);

        Author savedUser = authorRepo.save(author1);
        Author existUser = entityManager.find(Author.class, savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(author1.getEmail());

    }

    @Test
    public void testFindUserByEmail() {
        String email = "salai1@gmail.com";
        Author author = authorRepo.findByEmail(email);
        assertThat(author).isNotNull();

    }

    @Test
    public void testGetById() {
        Long authorId = 6l;

        Optional<Author> optionalAuthor = authorRepo.findById(authorId);
        Assertions.assertThat(optionalAuthor).isPresent();
        System.out.println(optionalAuthor.get());

    }

    @Test
    public void testListAllUser() {

        Iterable<Author> authors = authorRepo.findAll();
        Assertions.assertThat(authors).hasSizeGreaterThan(0);

        for (Author author : authorRepo.findAll()) {
            System.out.println(author);
        }
    }


    @Test
    public void testUpdate() {
        Long authorId = 1l;
        Optional<Author> optionalAuthor = authorRepo.findById(authorId);

        Author author = optionalAuthor.get();
        author.setLastName("Aung1");
        authorRepo.save(author);


        // these codes are show and check the update dat result at the consult (nothing to do with the DDB saving)
        Author updatedAuthor = authorRepo.findById(authorId).get();
        Assertions.assertThat(updatedAuthor.getLastName()).isEqualTo("Aung1");
    }



    @Test
    public void testDelete(){
        Long authorId = 7l;
        authorRepo.deleteById(authorId);
        Optional<Author> optionalAuthor = authorRepo.findById(authorId);
        Assertions.assertThat(optionalAuthor).isNotPresent();
    }




}
