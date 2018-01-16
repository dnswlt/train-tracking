package com.tsystems.ch.assessment.traintracking.controller;

import com.tsystems.ch.assessment.traintracking.model.EdgeState;
import com.tsystems.ch.assessment.traintracking.model.TrackingInfo;
import com.tsystems.ch.assessment.traintracking.service.Zugverfolgung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ZugverfolgungController {

    @Autowired
    private Zugverfolgung zugverfolgung;

    @GetMapping(path = "/trackinginfo")
    public TrackingInfo getTrackingInfo() {
        // TODO: Fill proper TrackingInfo
        return new TrackingInfo(LocalDateTime.now(), 0);
    }

    @GetMapping(path = "/edgestates")
    public List<EdgeState> getEdgeStates() {
        return zugverfolgung.getEdgeStates();
    }
}
