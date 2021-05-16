package ru.job4j.collection.examination;

/**
 * Исключение выявляющее неверно переданный документ
 * @author NIK STARTSEV
 * @version 1.0
 */
public class WrongFormatEmailsException extends Exception {
    public WrongFormatEmailsException(String errorMessage) {
        super(errorMessage);
    }
}
