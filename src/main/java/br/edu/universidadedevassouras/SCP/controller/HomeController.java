package br.edu.universidadedevassouras.SCP.controller;

import br.edu.universidadedevassouras.SCP.model.dto.JwtRequest;
import br.edu.universidadedevassouras.SCP.model.dto.JwtResponse;
import br.edu.universidadedevassouras.SCP.service.UserService;
import br.edu.universidadedevassouras.SCP.util.JwtUtility;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class HomeController {

    private JwtUtility jwtUtility;
    private AuthenticationManager authenticationManager;
    private UserService userService;

    public HomeController(JwtUtility jwtUtility, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping()
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
