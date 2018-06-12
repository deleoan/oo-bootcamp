package org.parkinglot;

class Car {
    private Ticket ticket;

    Ticket getCarTicket() {
        return ticket;
    }

    void setCarTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
