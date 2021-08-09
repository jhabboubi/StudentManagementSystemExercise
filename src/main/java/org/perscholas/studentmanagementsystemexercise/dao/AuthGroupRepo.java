package org.perscholas.studentmanagementsystemexercise.dao;

import org.perscholas.studentmanagementsystemexercise.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepo extends JpaRepository<AuthGroup,Long> {

    List<AuthGroup> findByUserId(Long userId);
}
