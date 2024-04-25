package com.ues.bibliotecabackend.Auth;

import org.springframework.web.bind.annotation.RestController;
import com.ues.bibliotecabackend.Auth.requests.LoginRequest;
import com.ues.bibliotecabackend.Auth.responses.LoginResponse;
import com.ues.bibliotecabackend.Usuario.requests.UsuarioCreate;
import com.ues.bibliotecabackend.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    return ResponseEntity.ok().body(authService.login(loginRequest));
  }

  @PostMapping("/register")
  public ResponseEntity<LoginResponse> register(@Valid @RequestBody UsuarioCreate usuario) {
    return ResponseEntity.ok().body(authService.register(usuario.toUsuario()));
  }

}
