package com.projects.oidc.service;

import com.projects.oidc.entity.User;
import com.projects.oidc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service

public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user){
        User prevUser = userRepository.findByUserId(user.getUserId());
        prevUser.setPassword(user.getPassword());
        prevUser.setApiKey(user.getApiKey());
        prevUser.setPrompts(user.getPrompts());
        userRepository.flush();
        return prevUser;
    }

    public User deleteUser(String userId){
        User user = userRepository.findByUserId(userId);
        userRepository.deleteByUserId(userId);
        return user;
    }
}
