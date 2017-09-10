package com.company;

//Създайте клас Event, който да има place; date; startHour;
// numberOFTickets,priceOfTicket както и конструктор с параметри
// и абстрактен метод boolean sellTicket(int num)throws
// NoMoreTicketException, който по подаден брой билети отнема
// от общия брой толкова, колкото са подадени и връща true,
// а ако билетите са свършили, хвърля изключението. Член
// променливите оставете с такъв модификатор за достъп, че
// да може да се виждат само в рамките на
// текущия пакет и в наследниците(за да спестите време).

public abstract class Event {

    protected String place;
    protected String date;
    protected String startHour;
    protected int numberOfTickets;
    protected float priceOfTickets;

    public Event(String place, String date, String startHour, int numberOfTickets, float priceOfTickets) {
        this.place = place;
        this.date = date;
        this.startHour = startHour;
        this.numberOfTickets = numberOfTickets;
        this.priceOfTickets = priceOfTickets;
    }

    public abstract boolean sellTickets (int num) throws NoMoreTicketException;
}
