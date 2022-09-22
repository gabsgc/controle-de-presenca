package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.model.entity.Usuario;
import br.edu.universidadedevassouras.SCP.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Usuario> user = repository.findByUsername(userName);
        if (user.isPresent()) {
           return user.get();
        }
       throw new UsernameNotFoundException("Dados inválidos!");
    }
}
