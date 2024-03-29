package br.com.vitorgabrielti.ms.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitorgabrielti.ms.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID>{
    
}
