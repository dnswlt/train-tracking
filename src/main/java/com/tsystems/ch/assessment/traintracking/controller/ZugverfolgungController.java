package com.tsystems.ch.assessment.traintracking.controller;

import com.tsystems.ch.assessment.traintracking.model.TrackingInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ZugverfolgungController {

    @GetMapping(path = "/trackinginfo")
    public TrackingInfo getTrackingInfo() {
        return new TrackingInfo(LocalDateTime.now(), 0);
    }
}
