package com.custom.message.exception;


import com.custom.message.enumerable.MessagesEnum;

/**
 * Ao lancar esta excecao, a mesma sera capturada pela classe ApiExceptionHandler onde sera tratada.
 *
 * @author Fernando Matheus
 */
public class CouldNotReadException extends RuntimeException {

        public CouldNotReadException(MessagesEnum messagesEnum) {
            super(messagesEnum.getMessage());
        }

        public CouldNotReadException(MessagesEnum messagesEnum, Throwable cause) {
            super(messagesEnum.getMessage(), cause);
        }

}
