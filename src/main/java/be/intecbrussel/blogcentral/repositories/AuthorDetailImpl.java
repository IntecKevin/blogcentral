package be.intecbrussel.blogcentral.repositories;
import java.util.Collection;

import be.intecbrussel.blogcentral.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public class AuthorDetailImpl implements UserDetails {


    private Author author;


    public AuthorDetailImpl(Author author) {
        this.author = author;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        Set<Article> articles = author.getArticles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

         for (Article article : articles) {
            authorities.add(new SimpleGrantedAuthority(article.getName()));
        }
        return authorities;
         */
        return null;
    }

    @Override
    public String getPassword() {
        return author.getPassword();
    }

    @Override
    public String getUsername() {
        return author.getUserName();
    }
/*
 // This override method is login to App with Username.

    @Override
    public String getUsername() {
        return author.getUserName();
    }

 */

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getFullName(){
        return this.author.getFullName();
    }

    // How can I get all the user information not to rewrite again

    public String getFirstName() {
        return author.getFirstName();
    }

    public String getLastName() {
        return author.getLastName();
    }

    public String getEmail() {
        return author.getEmail();
    }

    public String getStreetName() {
        return author.getStreetName();
    }

    public int getHouseNo() {
        return author.getHouseNo();
    }

    public String getCityName() {
        return author.getCityName();
    }

    public int getZipCode() {
        return author.getZipCode();
    }





    // How can I reuse the Author Class without rewriting following codes.

    public void setFirstName (String fistName) {
        this.author.setFirstName(fistName);
    }
    public void setLastName (String lastName) {
        this.author.setLastName(lastName);
    }
}
