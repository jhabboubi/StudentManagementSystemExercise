package org.perscholas.studentmanagementsystemexercise.security;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.studentmanagementsystemexercise.models.AuthGroup;
import org.perscholas.studentmanagementsystemexercise.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
@Slf4j
public class AppUserPrincipal implements UserDetails {

    private Users user;
    private List<AuthGroup> authGroups;


    public AppUserPrincipal(Users user, List<AuthGroup> authGroups) {
        this.user = user;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(null == authGroups){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroups.forEach(authGroup -> grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAuthGroup())));
        return grantedAuthorities;


    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
