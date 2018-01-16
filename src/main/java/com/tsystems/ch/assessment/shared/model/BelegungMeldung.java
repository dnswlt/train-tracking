package com.tsystems.ch.assessment.shared.model;

public class BelegungMeldung {
    private Edge edge;
    private boolean occupied;

    public BelegungMeldung(Edge edge, boolean occupied) {
        this.edge = edge;
        this.occupied = occupied;
    }

    public Edge getEdge() {
        return edge;
    }

    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public String toString() {
        return "B(" + edge + ":" + occupied + ")";
    }
}
