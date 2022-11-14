package com.fmatheus.app.exception;


import com.fmatheus.app.enumerable.MessageEnum;

/**
 * Ao lancar esta excecao, a mesma sera capturada pela classe AppExceptionHandler onde sera tratada.
 *
 * @author Fernando Matheus
 */
public class FileStorageException extends RuntimeException {

    public FileStorageException(MessageEnum messageEnum) {
        super(messageEnum.getMessage());
    }

    public FileStorageException(MessageEnum messageEnum, Throwable cause) {
        super(messageEnum.getMessage(), cause);
    }

}
