package be.intecbrussel.blogcentral;

import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

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
        Author author = new Author();
        author.setEmail("salai2@gmail.com");
        author.setPassword("salai2");
        author.setFirstName("Salai2");
        author.setLastName("Aung");

        Author savedUser =  authorRepo.save(author);
        Author existUser = entityManager.find(Author.class, savedUser.getId());
        assertThat (existUser.getEmail()).isEqualTo(author.getEmail());

    }

    @Test
    public void testFindUserByEmail(){
        String email = "salai1@gmail.com";
        Author author = authorRepo.findByEmail(email);
        assertThat(author).isNotNull();

    }

}
