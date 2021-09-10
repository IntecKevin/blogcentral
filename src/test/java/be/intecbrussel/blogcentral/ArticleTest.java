package be.intecbrussel.blogcentral;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.ArticleRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ArticleTest {

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateArticle() {
        Author author1 = new Author();
        Article article = new Article();
        article.setAuthor(author1);
        article.setPostTime(LocalDateTime.now());
        article.setPostDate(Date.from(Instant.now()));
        article.setArticleTitle("The art of a coffee");
        article.setArticleSummary("summary of coffee");
        article.setArticleText("aslfkbalsfbasfşasfasfa");




        Article savedArticle =  articleRepo.save(article);
        Article existArticle = entityManager.find(Article.class, savedArticle.getId());
        assertThat (existArticle.getArticleText()).isEqualTo(article.getArticleText());

    }
}