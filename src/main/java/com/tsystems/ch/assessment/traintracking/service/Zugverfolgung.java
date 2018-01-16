package com.tsystems.ch.assessment.traintracking.service;

import com.tsystems.ch.assessment.shared.model.BelegungMeldung;
import com.tsystems.ch.assessment.shared.service.MeldungQueue;
import com.tsystems.ch.assessment.shared.service.Network;
import com.tsystems.ch.assessment.traintracking.model.EdgeState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class Zugverfolgung {

    private static final Logger LOG = LoggerFactory.getLogger(Zugverfolgung.class);
    @Autowired
    private MeldungQueue queue;

    @Autowired
    private Network network;

    @PostConstruct
    public void startup() {
        // TODO: hier den Code einbauen
        new Thread(this::run).start();
    }

    public void run() {
        while (true) {
            BelegungMeldung meldung = queue.recv();
            LOG.info("Neue Belegung: {}", meldung);
        }
    }

    public List<EdgeState> getEdgeStates() {
        // TODO: return proper edge states
        return Arrays.asList(new EdgeState(network.getEdge(1, 2)));
    }
}
