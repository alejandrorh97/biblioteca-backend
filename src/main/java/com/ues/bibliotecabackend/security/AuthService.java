package com.ues.bibliotecabackend.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ues.bibliotecabackend.Auth.requests.LoginRequest;
import com.ues.bibliotecabackend.Auth.responses.LoginResponse;
import com.ues.bibliotecabackend.Usuario.Usuario;
import com.ues.bibliotecabackend.Usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthService {

  private final UsuarioRepository usuarioRepository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

  public LoginResponse login(LoginRequest loginRequest) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getCorreo(), loginRequest.getContrasena()));
    UserDetails userDetails = usuarioRepository.findByCorreo(loginRequest.getCorreo()).orElseThrow();
    String token = jwtService.getToken(userDetails);

    return LoginResponse.builder().jwt(token).build();
  }

  public LoginResponse register(Usuario usuario) {
    String contrasena = passwordEncoder.encode(usuario.getContrasena());
    usuario.setContrasena(contrasena);
    usuarioRepository.save(usuario);
    String token = jwtService.getToken(usuario);
    return LoginResponse.builder().jwt(token).build();
  }
  
}
