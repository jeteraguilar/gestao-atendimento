package com.atendopro.notification;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void enviarEmail(String para, String assunto, String mensagem) {
        // Implementar envio via SMTP ou AWS SES
    }
}