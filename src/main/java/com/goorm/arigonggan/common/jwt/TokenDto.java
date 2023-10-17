package com.goorm.arigonggan.common.jwt;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenDto {

    private String token;
    private Date tokenExpirationIn;

    public LocalDateTime getTokenExpirationDateTime() {
        return convertToLocalDateTime(tokenExpirationIn);
    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}
