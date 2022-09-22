package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.model.entity.Pessoa;
import br.edu.universidadedevassouras.SCP.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PessoaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Pessoa> user = repository.findByUsername(userName);
        if (user.isPresent()) {
            Pessoa usuario =  user.get();
            return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
        }
       throw new UsernameNotFoundException("Dados inválidos!");
    }
}
