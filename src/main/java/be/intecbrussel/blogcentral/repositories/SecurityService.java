package be.intecbrussel.blogcentral.repositories;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
