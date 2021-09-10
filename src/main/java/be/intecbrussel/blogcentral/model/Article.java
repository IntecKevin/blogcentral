package be.intecbrussel.blogcentral.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    //summary(length=255)
    //counter for the like??? - LET'S KEEP THIS TOMORROW TO ASK MANU
    //date and time
    //need to update the relation among columns

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date postDate;

    @Column
    private LocalDateTime postTime;

    @Column(nullable = false)
    private String articleText;

    @Column(nullable = false, length = 30)
    private String articleSummary;

    @Column(nullable = false, length = 60)
    private String articleTitle;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name= "author_id")
    private Author author;

    @OneToMany (mappedBy = "article", cascade = CascadeType.ALL)
     private List<Comment> comment;

    public Article(String articleText, String articleSummary,
                   String articleTitle, Author author, List<Comment> comment) {
        this.articleText = articleText;
        this.articleSummary = articleSummary;
        this.articleTitle = articleTitle;
        this.author = author;
        this.comment = comment;
    }

// need constructor for comment and author



    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
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

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
