// src/main/java/com/example/bookMS/service/UserService.java
package com.example.bookMS.service;

import com.example.bookMS.model.LoginRequest;
import com.example.bookMS.model.SignupRequest;
import com.example.bookMS.model.UserResponse;

public interface UserService {

    UserResponse signup(SignupRequest request);

    UserResponse login(LoginRequest request);
}
