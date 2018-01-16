package com.tsystems.ch.assessment.traintracking.service;

import com.tsystems.ch.assessment.shared.service.MeldungQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Zugverfolgung {

    @Autowired
    private MeldungQueue queue;


}
