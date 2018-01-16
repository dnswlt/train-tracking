package com.tsystems.ch.assessment.shared.service;

import com.tsystems.ch.assessment.shared.model.BelegungMeldung;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;

@Service
public class MeldungQueue {

    private static final Logger LOG = LoggerFactory.getLogger(MeldungQueue.class);

    private LinkedBlockingQueue<BelegungMeldung> queue = new LinkedBlockingQueue<>();

    public void send(BelegungMeldung meldung) {
        try {
            queue.put(meldung);
        } catch (InterruptedException e) {
            LOG.error("Could not send meldung.", e);
        }
    }

    public BelegungMeldung recv() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            LOG.error("Could not receive message", e);
            throw new IllegalStateException(e);
        }
    }
}
