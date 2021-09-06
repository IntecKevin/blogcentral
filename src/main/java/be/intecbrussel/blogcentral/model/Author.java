package be.intecbrussel.blogcentral.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true, length = 44)
    private String email;

    @Column (nullable = false, length = 64)
    private String password;


    @Column(nullable = false, length = 20)
    private String firstName;


    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 100)
    private String streetName;

    @Column(nullable = false, length = 10)
    private int houseNo;

    @Column(nullable = false, length = 20)
    private String cityName;

    @Column(nullable = false, length = 6)
    private int zipCode;

    @OneToMany(mappedBy="author", cascade = CascadeType.ALL)
    private List<Article> articles;

    @OneToMany(mappedBy="author", cascade = CascadeType.ALL)
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

    public Author(String email, String password, String firstName, String lastName,
                  String userName, String streetName, int houseNo, String cityName, int zipCode) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.streetName = streetName;
        this.houseNo = houseNo;
        this.cityName = cityName;
        this.zipCode = zipCode;
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
                '}';
    }

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
