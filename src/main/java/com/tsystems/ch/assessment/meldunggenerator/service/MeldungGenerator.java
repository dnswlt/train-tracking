package com.tsystems.ch.assessment.meldunggenerator.service;

import com.tsystems.ch.assessment.meldunggenerator.model.EdgeOccupancy;
import com.tsystems.ch.assessment.meldunggenerator.model.Train;
import com.tsystems.ch.assessment.shared.model.BelegungMeldung;
import com.tsystems.ch.assessment.shared.model.Edge;
import com.tsystems.ch.assessment.shared.service.MeldungQueue;
import com.tsystems.ch.assessment.shared.service.Network;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MeldungGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(MeldungGenerator.class);

    private int iterationCount;

    private List<Train> trains = new ArrayList<>();

    @Autowired
    private Network network;

    @Autowired
    private MeldungQueue queue;

    @PostConstruct
    public void init() {
        Train t1 = new Train("A", Arrays.asList(occ(2, 3, 5, 10), occ(3, 4, 0, 5)));
        Train t2 = new Train("B", Arrays.asList(occ(12, 15, 10, 50)));
        trains.add(t1);
        trains.add(t2);
    }

    private EdgeOccupancy occ(int from, int to, int start, int end) {
        return new EdgeOccupancy(network.getEdge(from, to), start, end);
    }

    @Scheduled(fixedRate = 100)
    public void moveTrains() {
        LOG.info("Round {}", ++iterationCount);
        for (Train train : trains) {
            if (train.remainingHead() == 0) {
                // Occupy new edge
                Edge nextEdge = network.getRandomSuccessor(train.getHead());
                enq(new BelegungMeldung(nextEdge, true));
                Edge leftEdge = train.enterEdge(nextEdge);
                if (leftEdge != null) {
                    enq(new BelegungMeldung(leftEdge, false));
                }
            } else {
                Edge leftEdge = train.move();
                if (leftEdge != null) {
                    enq(new BelegungMeldung(leftEdge, false));
                }
            }
        }
        LOG.info("Trains:\n{}", trains);
    }

    private void enq(BelegungMeldung meldung) {
        queue.send(meldung);
    }
}
