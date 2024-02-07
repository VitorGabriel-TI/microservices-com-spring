package br.com.vitorgabrielti.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.vitorgabrielti.ms.email.dtos.EmailRecordDto;
import br.com.vitorgabrielti.ms.email.models.EmailModel;
import br.com.vitorgabrielti.ms.email.services.EmailService;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto, emailModel);
        emailService.sendEmail(emailModel);
    }
}
