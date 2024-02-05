package br.com.vitorgabrielti.ms.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitorgabrielti.ms.user.models.UserModel;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID>{
    
}
