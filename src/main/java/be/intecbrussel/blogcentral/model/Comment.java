package be.intecbrussel.blogcentral.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Author author;

    @ManyToOne
    @JoinColumn(name= "article_id")
    private Article article;

    @Column
    private Date postDate;

    @Column (name= "comment_text", length = 200)
    private String commentText;

    public Comment(Long id, Author author, Article article, Date postDate, String commentText) {
        this.id = id;
        this.author = author;
        this.article = article;
        this.postDate = postDate;
        this.commentText = commentText;
    }

    public Comment(Author author, Article article, Date postDate, String commentText) {
        this.author = author;
        this.article = article;
        this.postDate = postDate;
        this.commentText = commentText;
    }

    public Comment() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                ", article=" + article +
                ", postDate=" + postDate +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
