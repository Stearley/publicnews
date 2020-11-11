package com.ippsby.publicnews.service;

import com.ippsby.publicnews.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserModel save(UserModel user);
}
