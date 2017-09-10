package com.company;

public class UnrecognisedRowException extends Exception {
    @Override
    public String getMessage() {
        return "That row is not recognized ! ";

    }
}
