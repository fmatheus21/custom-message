package com.custom.message.exception.handler;

import com.custom.message.enumerable.MessagesEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageResponseHandler {

    private LocalDateTime timestamp = LocalDateTime.now();
    private int statusCode;
    private String statusDescription;
    private String cause;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldsResponseHandler> fields;


    public MessageResponseHandler(MessagesEnum messagesEnum, String cause, String message) {
        this.statusCode = messagesEnum.getHttpSttus().value();
        this.statusDescription = messagesEnum.getHttpSttus().getReasonPhrase();
        this.cause = cause;
        this.message = message;
    }

}