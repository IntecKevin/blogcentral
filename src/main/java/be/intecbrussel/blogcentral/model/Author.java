package be.intecbrussel.blogcentral.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity (name = "Author")
@Table(name = "authors",
        uniqueConstraints = {@UniqueConstraint(name = "author_email_unique", columnNames = "email")})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name= "email", nullable = false,  length = 44)
    private String email;

    @Column (name= "password", nullable = false, length = 64)
    private String password;


    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;


    @Column(name= "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name="user_name", nullable = false, length = 20)
    private String userName;

    @Column(name="street_name", nullable = false, length = 100)
    private String streetName;

    @Column(name = "house_no", nullable = false, length = 10)
    private int houseNo;

    @Column( name= "city_name", nullable = false, length = 20)
    private String cityName;

    @Column(name = "zip_code",nullable = false, length = 6)
    private int zipCode;


//    @OneToMany( cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id")
    @OneToMany(mappedBy="author", cascade = CascadeType.ALL)
    private List<Article> articles;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private List<Comment> comments;

/*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authors_articles", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))
    private Set<Article> roles = new HashSet<>();
  */




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Author(Long id, String email, String password, String firstName, String lastName,
                  String userName, String streetName, int houseNo, String cityName, int zipCode,
                  List<Article> articles, List<Comment> comments) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.streetName = streetName;
        this.houseNo = houseNo;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.articles = articles;
        this.comments = comments;
    }

    public Author(String email, String password, String firstName, String lastName,
                  String userName, String streetName, int houseNo, String cityName, int zipCode,
                  List<Article> articles, List<Comment> comments) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.streetName = streetName;
        this.houseNo = houseNo;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.articles = articles;
        this.comments = comments;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNo=" + houseNo +
                ", cityName='" + cityName + '\'' +
                ", zipCode=" + zipCode +
                ", articles=" + articles +
                ", comments=" + comments +
                '}';
    }


    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
