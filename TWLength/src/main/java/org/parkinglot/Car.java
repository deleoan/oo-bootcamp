package org.parkinglot;

class Car {
    private Ticket ticket;

    Ticket getTicket() {
        return ticket;
    }

    void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
