package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.auth.AuthenticationRequest;
import com.example.gestiondestock.dto.auth.AuthenticationResponse;
import com.example.gestiondestock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;
import static com.example.gestiondestock.utils.Constants.AUTHENTICATION_ENDPOINT;

//@RequestMapping(APP_ROOT + AUTHENTICATION_ENDPOINT)
@RequestMapping(AUTHENTICATION_ENDPOINT)
public interface AuthenticationApi {


    @PostMapping( "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
