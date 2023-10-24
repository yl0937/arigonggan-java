package com.goorm.arigonggan.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByStudentNum(String studentNum);

    User findByStudentNum(String studentNum);

    List<User> findAllByIdIn(List<Long> userList);
}