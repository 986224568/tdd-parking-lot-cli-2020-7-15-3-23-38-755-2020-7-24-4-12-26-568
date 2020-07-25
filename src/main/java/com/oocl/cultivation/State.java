package com.oocl.cultivation;

public enum State {
    parkedCar(1), notParkedCar(2), usedTicket(3), notUsedTicket(4);
    private int index;

    State(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}