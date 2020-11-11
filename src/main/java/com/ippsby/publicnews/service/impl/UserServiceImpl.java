package com.ippsby.publicnews.service.impl;

import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.repository.UserRepository;
import com.ippsby.publicnews.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel save(UserModel user) {
        return null;
    }
    private final UserRepository userRepository;
}
