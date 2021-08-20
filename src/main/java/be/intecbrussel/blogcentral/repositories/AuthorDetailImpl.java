package be.intecbrussel.blogcentral.repositories;
import java.util.Collection;

import be.intecbrussel.blogcentral.model.Author;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthorDetailImpl implements UserDetails {
    private Author author;

    public AuthorDetailImpl(Author author) {
        this.author = author;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return author.getPassword();
    }

    @Override
    public String getUsername() {
        return author.getEmail();
    }

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

    public String getFullName() {
        return author.getFirstName() + " " + author.getLastName();
    }

}
