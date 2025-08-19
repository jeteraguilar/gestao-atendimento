package com.atendopro.service;

import com.atendopro.model.Usuario;
import com.atendopro.repository.UsuarioRepository;
import com.atendopro.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

public class AuthServiceTest {

    private UsuarioRepository usuarioRepository;
    private JwtUtil jwtUtil;
    private AuthService authService;

    @BeforeEach
    void setup() {
        usuarioRepository = Mockito.mock(UsuarioRepository.class);
        jwtUtil = new JwtUtil();
        authService = new AuthService(usuarioRepository, jwtUtil);
    }

    @Test
    void testLoginUsuarioNaoEncontrado() {
        when(usuarioRepository.findByEmail("teste@email.com")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> authService.login("teste@email.com", "1234"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Usuário não encontrado");
    }

    @Test
    void testLoginSenhaInvalida() {
        Usuario usuario = new Usuario(1L, "Teste", "teste@email.com", "senhaCorreta", "TERAPEUTA");
        when(usuarioRepository.findByEmail("teste@email.com")).thenReturn(Optional.of(usuario));

        assertThatThrownBy(() -> authService.login("teste@email.com", "senhaErrada"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Senha inválida");
    }
}
