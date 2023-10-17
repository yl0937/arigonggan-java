package com.goorm.arigonggan.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByStudentNum(String studentNum);

    User findByStudentNum(String studentNum);
}