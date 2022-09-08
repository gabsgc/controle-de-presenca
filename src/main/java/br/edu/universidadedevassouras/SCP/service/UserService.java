package br.edu.universidadedevassouras.SCP.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User("admin",
                "$2a$12$kgMRkWN2U20CcZNaG12nf.hl4CXnfNcQ7fj1ihkFmkQ7RkFQzlxSW",
                new ArrayList<>());
    }
}
