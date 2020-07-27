package com.oocl.cultivation;

public enum TicketState {
    usedTicket(3), notUsedTicket(4);
    private int index;

    TicketState(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }
}