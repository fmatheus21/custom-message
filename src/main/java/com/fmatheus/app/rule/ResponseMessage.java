package com.fmatheus.app.rule;

import com.fmatheus.app.enumerable.MessageEnum;
import com.fmatheus.app.exception.BadRequestException;
import com.fmatheus.app.exception.ForbiddenException;
import com.fmatheus.app.exception.handler.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class ResponseMessage {

    @Autowired
    private MessageSource messageSource;

    private MessageResponse messageResponse(MessageEnum messageEnum) {
        String message = messageSource.getMessage(messageEnum.getMessage(), null, LocaleContextHolder.getLocale());
        return new MessageResponse(messageEnum, messageEnum.getHttpSttus().getReasonPhrase(), message);
    }

    public MessageResponse successUpdate() {
        return messageResponse(MessageEnum.SUCCESS_UPDATE);
    }

    public MessageResponse successCreate() {
        return messageResponse(MessageEnum.SUCCESS_CREATE);
    }

    public MessageResponse successDelete() {
        return messageResponse(MessageEnum.SUCCESS_DELETE);
    }

    public MessageResponse error(HttpStatus httpStatus, String message) {
        return new MessageResponse(httpStatus, message);
    }

    public BadRequestException errorRecordExist() {
        return new BadRequestException(MessageEnum.ERROR_RECORD_EXIST);
    }

    public BadRequestException errorNotFound() {
        return new BadRequestException(MessageEnum.ERROR_NOT_FOUND);
    }

    public ForbiddenException errorNotPermission() {
        return new ForbiddenException(MessageEnum.ERROR_NOT_PERMISSION.getMessage());
    }

    public InternalError errorInternal() {
        return new InternalError(MessageEnum.ERROR_INTERNAL.getMessage());
    }

    public ForbiddenException errorForbidden() {
        return new ForbiddenException(MessageEnum.ERROR_FORBIDDEN.getMessage());
    }

    public BadRequestException errorCambiumNotConverter() {
        return new BadRequestException(MessageEnum.ERROR_CAMBIUM_NOT_CONVERTER);
    }


}
