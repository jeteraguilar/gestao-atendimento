package com.atendopro.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteDTO {
    private String nome;
    private String email;
    private String telefone;
    private String historicoClinico;
}