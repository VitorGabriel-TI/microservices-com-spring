package br.com.vitorgabrielti.ms.user.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vitorgabrielti.ms.user.models.UserModel;
import br.com.vitorgabrielti.ms.user.producers.UserProducer;
import br.com.vitorgabrielti.ms.user.repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }


    @Transactional
    public UserModel save(UserModel userModel){
        userModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
