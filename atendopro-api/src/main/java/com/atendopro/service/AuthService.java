package com.atendopro.service;

import com.atendopro.model.Usuario;
import com.atendopro.repository.UsuarioRepository;
import com.atendopro.security.JwtUtil;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public String login(String email, String senha) {
        Usuario user = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getSenha().equals(senha)) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtUtil.generateToken(email);
    }
}
