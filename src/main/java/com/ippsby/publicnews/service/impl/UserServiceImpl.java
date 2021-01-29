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
    public void delete(UserModel userData) {
        userRepository.delete(userData);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel login(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    @Override
    public UserModel find(long Id) {
        return userRepository.findById(Id).get();
    }

    @Override
    public UserModel getByRoleId(long roleId) {
        return userRepository.getRoleId(roleId);
    }


    private final UserRepository userRepository;


}
