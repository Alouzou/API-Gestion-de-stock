package com.example.gestiondestock.services.auth;

import com.example.gestiondestock.dto.UtilisateurDto;
import com.example.gestiondestock.model.auth.ExtendedUser;
import com.example.gestiondestock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurService utilisateurService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur = utilisateurService.findByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotDePasse(),  utilisateur.getEntreprise().getId(), authorities);

    }
}
