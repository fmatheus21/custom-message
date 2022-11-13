package com.fmatheus.app.exception.handler.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fmatheus.app.enumerable.MessagesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {

    private LocalDateTime timestamp = LocalDateTime.now();
    private int statusCode;
    private String statusDescription;
    private String cause;
    private String message;
    private String path;


    public MessageResponse(MessagesEnum messagesEnum, String cause, String message) {
        this.statusCode = messagesEnum.getHttpSttus().value();
        this.statusDescription = messagesEnum.getHttpSttus().name();
        this.cause = cause;
        this.message = message;
    }

    public MessageResponse(MessagesEnum messagesEnum, String cause, String message, URI uri) {
        this.statusCode = messagesEnum.getHttpSttus().value();
        this.statusDescription = messagesEnum.getHttpSttus().name();
        this.cause = cause;
        this.message = message;
        this.path = uri.getPath();
    }

    public MessageResponse(HttpStatus httpStatus, String message) {
        this.statusCode = httpStatus.value();
        this.statusDescription = httpStatus.name();
        this.cause = httpStatus.getReasonPhrase();
        this.message = message;
    }

}