package com.cts.Productmanagement.controller;

import com.cts.Productmanagement.entity.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody Merchant merchant) throws Exception {
        Authentication authObject = null;
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(merchant.getEmail(),merchant.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("Invalid Credentials");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
