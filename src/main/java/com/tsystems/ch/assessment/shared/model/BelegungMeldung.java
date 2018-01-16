package com.tsystems.ch.assessment.shared.model;

public class BelegungMeldung {
    private String edgeId;
    private boolean occupied;

    public BelegungMeldung(String edgeId, boolean occupied) {
        this.edgeId = edgeId;
        this.occupied = occupied;
    }

    public String getEdgeId() {
        return edgeId;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
