package com.goorm.arigonggan.domain.user;

import com.goorm.arigonggan.controller.dto.UserRequest;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentNum;
    @CreatedDate
    private LocalDateTime createdAt;

    public static User from(UserRequest userRequest) {
        return User.builder()
                .studentNum(userRequest.getStudentNum())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
