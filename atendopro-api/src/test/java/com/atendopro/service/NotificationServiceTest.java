package com.atendopro.service;

import com.atendopro.notification.EmailService;
import com.atendopro.notification.WhatsAppService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {

    private EmailService emailService;
    private WhatsAppService whatsAppService;
    private NotificationService notificationService;

    @BeforeEach
    void setup() {
        emailService = Mockito.mock(EmailService.class);
        whatsAppService = Mockito.mock(WhatsAppService.class);
        notificationService = new NotificationService(emailService, whatsAppService);
    }

    @Test
    void testEnviarEmail() {
        notificationService.enviarEmail("teste@dominio.com", "Assunto", "Mensagem");
        Mockito.verify(emailService).enviarEmail("teste@dominio.com", "Assunto", "Mensagem");
    }

    @Test
    void testEnviarWhatsApp() {
        notificationService.enviarWhatsApp("+5511999999999", "Mensagem");
        Mockito.verify(whatsAppService).enviarWhatsApp("+5511999999999", "Mensagem");
    }
}
