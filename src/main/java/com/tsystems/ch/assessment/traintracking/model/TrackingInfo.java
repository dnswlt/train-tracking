package com.tsystems.ch.assessment.traintracking.model;

import java.time.LocalDateTime;

public class TrackingInfo {

    private LocalDateTime created;
    private int numberOfTrains;

    public TrackingInfo(LocalDateTime created, int numberOfTrains) {
        this.created = created;
        this.numberOfTrains = numberOfTrains;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getNumberOfTrains() {
        return numberOfTrains;
    }
}
