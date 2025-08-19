package com.atendopro.service;

import com.atendopro.model.Paciente;

import com.atendopro.repository.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Testcontainers
public class PacienteServiceIntegrationTest {

    @Container
    public static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("postgres")
            .withPassword("postgres");

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    void testSalvarEListarPacientes() {
        Paciente paciente = Paciente.builder()
                .nome("João Silva")
                .email("joao@email.com")
                .telefone("11999999999")
                .historicoClinico("Paciente inicial")
                .build();

        pacienteService.salvar(paciente);

        List<Paciente> pacientes = pacienteService.listarTodos();
        assertThat(pacientes).isNotEmpty();
        assertThat(pacientes.get(0).getNome()).isEqualTo("João Silva");
    }
}