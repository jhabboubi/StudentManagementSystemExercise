package org.perscholas.studentmanagementsystemexercise;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.studentmanagementsystemexercise.dao.AuthGroupRepo;
import org.perscholas.studentmanagementsystemexercise.dao.UsersRepo;
import org.perscholas.studentmanagementsystemexercise.models.AuthGroup;
import org.perscholas.studentmanagementsystemexercise.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Component
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AppRunner implements CommandLineRunner {
    // autowire all repo's/services

    UsersRepo usersRepo;
    AuthGroupRepo authGroupRepo;

    @Autowired
    public AppRunner(UsersRepo usersRepo, AuthGroupRepo authGroupRepo) {
        this.usersRepo = usersRepo;
        this.authGroupRepo = authGroupRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // add dummy data
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("**** Start adding Users sql statements ****");
        usersRepo.save(new Users("habboubi", "habboubi@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        usersRepo.save(new Users("admin", "admin@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        usersRepo.save(new Users("student_one", "student_one@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        usersRepo.save(new Users("student_two", "student_two@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        usersRepo.save(new Users("student_three", "student_three@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        log.info("**** End of sql statements ****");
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("**** Start adding AuthGroup sql statements ****");
        authGroupRepo.save(new AuthGroup(1L, "ROLE_ADMIN"));
        authGroupRepo.save(new AuthGroup(1L, "ROLE_USER"));
        authGroupRepo.save(new AuthGroup(1L, "WRITE"));
        authGroupRepo.save(new AuthGroup(2L, "ROLE_ADMIN"));
        authGroupRepo.save(new AuthGroup(2L, "ROLE_USER"));
        authGroupRepo.save(new AuthGroup(3L, "ROLE_USER"));
        authGroupRepo.save(new AuthGroup(4L, "ROLE_USER"));
        authGroupRepo.save(new AuthGroup(5L, "ROLE_USER"));
        log.info("**** End of sql statements ****");
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");






    }
}
