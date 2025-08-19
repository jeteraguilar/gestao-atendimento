package com.atendopro.service;

import com.atendopro.notification.EmailService;
import com.atendopro.notification.WhatsAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final EmailService emailService;
    private final WhatsAppService whatsAppService;

    public void enviarEmail(String para, String assunto, String mensagem) {
        emailService.enviarEmail(para, assunto, mensagem);
    }

    public void enviarWhatsApp(String numero, String mensagem) {
        whatsAppService.enviarWhatsApp(numero, mensagem);
    }
}