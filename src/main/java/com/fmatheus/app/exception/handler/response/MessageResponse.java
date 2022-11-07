package com.fmatheus.app.exception.handler.response;

import com.fmatheus.app.enumerable.MessagesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageResponse {

    private LocalDateTime timestamp = LocalDateTime.now();
    private int statusCode;
    private String statusDescription;
    private String cause;
    private String message;
    private URI uri;


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
        this.uri = uri;
    }

}