package com.example.StudentPerfomanceTracking.security.jwt;

import com.example.StudentPerfomanceTracking.dto.UserLoginDTO;

public class AuthResponse {
    private String token;

    boolean authenticated;

    UserLoginDTO userLoginDTO;

    public AuthResponse(String token) {
        this.token = token;
    }

    public AuthResponse(String token, boolean authenticated) {
        this.token = token;
        this.authenticated = authenticated;
    }

    public AuthResponse(String token, boolean authenticated, UserLoginDTO userLoginDTO) {
        this.token = token;
        this.authenticated = authenticated;
        this.userLoginDTO = userLoginDTO;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserLoginDTO getUserLoginDTO() {
        return userLoginDTO;
    }

    public void setUserLoginDTO(UserLoginDTO userLoginDTO) {
        this.userLoginDTO = userLoginDTO;
    }
}
