package ru.job4j.collection.examination;

public class WrongFormatEmailsException extends Exception {
    public WrongFormatEmailsException(String errorMessage) {
        super(errorMessage);
    }
}
