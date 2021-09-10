package be.intecbrussel.blogcentral.services;

import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorDetailImpl;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomAuthorDetailService  implements UserDetailsService {

    @Autowired
    private AuthorRepo authorRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Author author = authorRepo.findByEmail(email);
        if (author == null) {
            throw new UsernameNotFoundException("User not found user with that email" + email);
        }

        return new AuthorDetailImpl(author);
    }
}


