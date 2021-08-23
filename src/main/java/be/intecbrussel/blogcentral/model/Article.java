package be.intecbrussel.blogcentral.model;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String articleText;

    @Column
    private String articleTitle;

    @ManyToOne
    private Author author;

    @OneToMany
    private Comment comment;

    public Article(Long id, String articleText, String articleTitle, Author author, Comment comment) {
        this.id = id;
        this.articleText = articleText;
        this.articleTitle = articleTitle;
        this.author = author;
        this.comment = comment;
    }

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
