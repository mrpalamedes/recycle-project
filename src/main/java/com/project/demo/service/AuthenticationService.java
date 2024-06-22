package com.project.demo.service;

import com.project.demo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.config.MessageString;
import com.project.demo.entity.AuthenticationToken;
import com.project.demo.entity.User;
import com.project.demo.exception.AuthenticationFailException;
import com.project.demo.utils.Helper;


@Service
public class AuthenticationService {
    
    @Autowired
    TokenRepository repository;

    public void saveConfirmationToken(AuthenticationToken authenticationToken){
        repository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user){
        return repository.findTokenByUser(user);
    }

    public User getUser(String token){
        AuthenticationToken authenticationToken = repository.findTokenByToken(token);
        if(Helper.notNull(authenticationToken)){
            if(Helper.notNull(authenticationToken.getUser())){
                return authenticationToken.getUser();
            }
        }
        return null;
    }

    public void authenticate(String token) throws AuthenticationFailException{
        if(!Helper.notNull(token)){
            throw new AuthenticationFailException(MessageString.AUTH_TOEKN_NOT_PRESENT);
        }
        if(!Helper.notNull(getUser(token))){
            throw new AuthenticationFailException(MessageString.AUTH_TOEKN_NOT_VALID);
        }
    }
}
