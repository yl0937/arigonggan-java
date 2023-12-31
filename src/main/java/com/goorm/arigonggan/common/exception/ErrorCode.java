package com.goorm.arigonggan.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, 40001, "입력값 유효성 검사에 실패하였습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, 40002, "사용자를 찾을 수 없습니다."),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, 40003, "잘못된 토큰입니다."),
    ACCESS_TOKEN_OMISSION(HttpStatus.UNAUTHORIZED, 40004, "인증 정보(액세스 토큰)가 누락되었습니다."),
    EXPIRED_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, 40005, "만료된 액세스 토큰입니다."),
    NOT_POSSIBLE_CANCELLATION(HttpStatus.BAD_REQUEST,40006,"취소 불 가능한 예약 입니다."),
    RESERVATION_NOT_FOUND(HttpStatus.BAD_REQUEST,40007,"예약 내역을 찾을 수 없습니다."),
    SEAT_NOT_FOUND(HttpStatus.BAD_REQUEST,40008,"좌석을 찾을 수 없습니다."),
    DISABLE_SEAT(HttpStatus.BAD_REQUEST,40009,"사용 불가능한 좌석입니다."),
    DISABLE_USER(HttpStatus.BAD_REQUEST,40010,"disable된 유저입니다."),
    CANNOT_BOOKED(HttpStatus.BAD_REQUEST,40011,"예약을 확정할 수 있는 시간이 아닙니다."),
    FORBIDDEN_REQUEST(HttpStatus.FORBIDDEN, 40300, "해당 요청에 대한 권한이 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 50000, "예상치 못한 오류가 발생했습니다.");


    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
