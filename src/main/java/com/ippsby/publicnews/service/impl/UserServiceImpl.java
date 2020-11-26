package com.ippsby.publicnews.service.impl;

import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.repository.UserRepository;
import com.ippsby.publicnews.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel findById(Long userId) {
        return null;
    }

    @Override
    public void delete(UserModel userId) {
        userRepository.delete(userId);
    }


    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }


    private final UserRepository userRepository;

    @Override
    public UserModel login(String username, String password) {
        return userRepository.;
    }
}