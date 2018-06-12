package org.parkinglot;

class Ticket {

    int ticketNumber;

    Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    Ticket getTicket() {
        return new Ticket(ticketNumber);
    }
}
