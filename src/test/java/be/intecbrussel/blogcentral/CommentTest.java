package be.intecbrussel.blogcentral;


import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.model.Comment;
import be.intecbrussel.blogcentral.repositories.ArticleRepo;
import be.intecbrussel.blogcentral.repositories.CommentRepo;
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
public class CommentTest {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testCreateComment() {
        Article article = new Article();


        Comment comment = new Comment();
        comment.setPostDate(Date.from(Instant.now()));

//        comment.setArticle(article);
        comment.setCommentText("Shitty friday !!!!");


        Comment savedComment =  commentRepo.save(comment);
        Comment existComment = entityManager.find(Comment.class, savedComment.getId());
        assertThat (existComment.getCommentText() ).isEqualTo(comment.getCommentText());



    }

}
