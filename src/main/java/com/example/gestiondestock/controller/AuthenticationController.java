package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.AuthenticationApi;
import com.example.gestiondestock.dto.auth.AuthenticationRequest;
import com.example.gestiondestock.dto.auth.AuthenticationResponse;
import com.example.gestiondestock.model.auth.ExtendedUser;
import com.example.gestiondestock.services.auth.ApplicationUserDetailsService;
import com.example.gestiondestock.utils.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;
import static com.example.gestiondestock.utils.Constants.AUTHENTICATION_ENDPOINT;

@RestController
//@RequestMapping(APP_ROOT + AUTHENTICATION_ENDPOINT)
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;



    @Autowired
    private JwtUtil jwtUtil;

//
//    @GetMapping("/tokenBidon/{username}")
//    public String tokenBidon(@PathVariable("username") String username){
//
//        UserDetails extendedUser = userDetailsService.loadUserByUsername(username);
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("role", "user");
////        return "users";
//        return Jwts.builder()
//                .setSubject(extendedUser.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, "ThisIsASecretKeyForJWTSigning12345HYSTjslamsksdndskmd52874IHDSJKJsdkndkm")
//                .compact();
//    }

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }


    @GetMapping("/tokenBid/tester/{ps}")
    public String tokenBid(@PathVariable("ps") String password){
        return passwordEncoder.encode(password);
//        return jwtUtil.unTokenBidon();
    }
////    @Override
////    public String generateToken() {
////        return jwtUtil.createToken();
////    }
}
