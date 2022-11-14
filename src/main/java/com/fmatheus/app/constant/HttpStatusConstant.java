package com.fmatheus.app.constant;

import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
public class HttpStatusConstant {

    private HttpStatusConstant() {
        throw new IllegalStateException(getClass().getName());
    }

    public static final String OK = HttpStatus.OK.getReasonPhrase();
    public static final String OK_NUMBER = String.valueOf(HttpStatus.OK.value());
    public static final String CREATED = HttpStatus.CREATED.getReasonPhrase();
    public static final String CREATED_NUMBER = String.valueOf(HttpStatus.CREATED.value());
    public static final String FORBIDDEN = HttpStatus.FORBIDDEN.getReasonPhrase();
    public static final String FORBIDDEN_NUMBER = String.valueOf(HttpStatus.FORBIDDEN.value());
    public static final String INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    public static final String INTERNAL_SERVER_ERROR_NUMBER = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
    public static final String NO_CONTENT = HttpStatus.NO_CONTENT.getReasonPhrase();
    public static final String NO_CONTENT_NUMBER = String.valueOf(HttpStatus.NO_CONTENT.value());
    public static final String UNAUTHORIZED = HttpStatus.UNAUTHORIZED.getReasonPhrase();
    public static final String UNAUTHORIZED_NUMBER = String.valueOf(HttpStatus.UNAUTHORIZED.value());
    public static final String BAD_REQUEST = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final String BAD_REQUEST_NUMBER = String.valueOf(HttpStatus.BAD_REQUEST.value());
    public static final String NOT_FOUND = HttpStatus.NOT_FOUND.getReasonPhrase();
    public static final String NOT_FOUND_NUMBER = String.valueOf(HttpStatus.NOT_FOUND.value());

}