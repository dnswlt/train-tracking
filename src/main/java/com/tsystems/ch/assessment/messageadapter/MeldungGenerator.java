package com.tsystems.ch.assessment.messageadapter;

import com.tsystems.ch.assessment.shared.service.MeldungQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MeldungGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(MeldungGenerator.class);

    private int iterationCount;

    @Autowired
    private MeldungQueue queue;

    @Scheduled(fixedRate = 1000L)
    public void moveTrains() {
        LOG.debug("Round {}", ++iterationCount);

    }
}
