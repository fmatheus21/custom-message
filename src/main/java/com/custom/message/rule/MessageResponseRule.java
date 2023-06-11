package com.custom.message.rule;

import com.custom.message.enumerable.MessagesEnum;
import com.custom.message.exception.BadRequestException;
import com.custom.message.exception.ForbiddenException;
import com.custom.message.exception.handler.MessageResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


@Component
public class MessageResponseRule {

    @Autowired
    private MessageSource messageSource;

    public MessageResponseHandler messageResponse(MessagesEnum messagesEnum) {
        String message = messageSource.getMessage(messagesEnum.getMessage(), null, LocaleContextHolder.getLocale());
        return new MessageResponseHandler(messagesEnum, messagesEnum.getHttpSttus().getReasonPhrase(), message);
    }

    public MessageResponseHandler messageSuccessUpdate() {
        return messageResponse(MessagesEnum.SUCCESS_UPDATE);
    }

    public MessageResponseHandler messageSuccessCreate() {
        return messageResponse(MessagesEnum.SUCCESS_CREATE);
    }

    public MessageResponseHandler messageSuccessDelete() {
        return messageResponse(MessagesEnum.SUCCESS_DELETE);
    }

    public BadRequestException errorBadRequest(MessagesEnum messagesEnum) {
        return new BadRequestException(messagesEnum);
    }

    public BadRequestException errorExistCnpj() {
        return new BadRequestException(MessagesEnum.ERROR_EXIST_CNPJ);
    }

    public BadRequestException errorRecordNotExist() {
        return new BadRequestException(MessagesEnum.ERROR_RECORD_NOT_EXIST);
    }

    public BadRequestException errorExistRecord() {
        return new BadRequestException(MessagesEnum.ERROR_EXIST_RECORD);
    }

    public ForbiddenException errorForbidden() {
        return new ForbiddenException(MessagesEnum.ERROR_FORBIDDEN.getMessage());
    }


}
