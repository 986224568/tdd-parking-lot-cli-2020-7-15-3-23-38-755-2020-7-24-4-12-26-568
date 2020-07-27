package com.oocl.cultivation;

public enum CarState {
    parkedCar(1), notParkedCar(2);
    private int index;

    CarState(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }
}