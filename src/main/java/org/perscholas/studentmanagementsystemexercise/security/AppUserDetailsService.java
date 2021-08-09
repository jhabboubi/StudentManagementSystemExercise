package org.perscholas.studentmanagementsystemexercise.security;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.studentmanagementsystemexercise.dao.AuthGroupRepo;
import org.perscholas.studentmanagementsystemexercise.dao.UsersRepo;
import org.perscholas.studentmanagementsystemexercise.models.AuthGroup;
import org.perscholas.studentmanagementsystemexercise.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AppUserDetailsService implements UserDetailsService {

    UsersRepo usersRepo;
    AuthGroupRepo authGroupRepo;


    public AppUserDetailsService(UsersRepo usersRepo, AuthGroupRepo authGroupRepo) {
        this.usersRepo = usersRepo;
        this.authGroupRepo = authGroupRepo;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Users> user = usersRepo.findByEmail(s);
        if(user.isEmpty())
            throw new UsernameNotFoundException("No user " + s);
        List<AuthGroup> authGroups = authGroupRepo.findByUserId(user.get().getId());
        log.warn(authGroups.toString());
        return new AppUserPrincipal(user.get(),authGroups);
    }
}
