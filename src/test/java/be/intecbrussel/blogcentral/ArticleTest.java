package be.intecbrussel.blogcentral;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.ArticleRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

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
        Article article1 = new Article();
        article1.getAuthor().getUserName();
        article1.setPostTime(LocalDateTime.now());
        article1.setPostDate(Date.from(Instant.now()));
        article1.setArticleTitle("The art of a coffee");
        article1.setArticleSummary("summary of coffee");
        article1.setArticleText("aslfkbalsfbasfşasfasfa");




        Article savedArticle =  articleRepo.save(article1);
        Article existArticle = entityManager.find(Article.class, savedArticle.getId());
        assertThat (existArticle.getArticleText()).isEqualTo(article1.getArticleText());

    }

    @Test
    public void testFindByTitle() {
        Long articleId = 3l;

        Optional<Article> article= articleRepo.findById(articleId);
        assertThat(article).isNotNull();

    }

    @Test
    public void testGetById() {
        Long articleId = 4l;
        Optional<Article> optionalArticle= articleRepo.findById(articleId);
        Assertions.assertThat(optionalArticle).isPresent();
        System.out.println(optionalArticle.get());

    }

    @Test
    public void testListAllUser() {

        Iterable<Article> articles = articleRepo.findAll();
        Assertions.assertThat(articles).hasSizeGreaterThan(0);

        for (Article article: articleRepo.findAll()) {
            System.out.println(article);
        }
    }


    @Test
    public void testUpdate() {

        Long articleId = 4l;
        Optional<Article> optionalArticle= articleRepo.findById(articleId);

        Article article = optionalArticle.get();
        article.setArticleTitle("Test-99");
        articleRepo.save(article);


        Article updateArticle = articleRepo.findById(articleId).get();
        Assertions.assertThat((updateArticle.getArticleTitle())).isEqualTo("Test-99");

    }



    @Test
    public void testDelete(){

        Long articleId = 4l;
        Optional<Article> optionalArticle= articleRepo.findById(articleId);
        Assertions.assertThat(optionalArticle).isNotPresent();
    }
}
