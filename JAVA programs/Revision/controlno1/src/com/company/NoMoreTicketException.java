package com.company;

public class NoMoreTicketException extends Exception {
    @Override
    public String getMessage() {
        return "There are no more tickets";
    }

}
