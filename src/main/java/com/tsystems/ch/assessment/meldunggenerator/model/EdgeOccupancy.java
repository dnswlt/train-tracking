package com.tsystems.ch.assessment.meldunggenerator.model;

import com.tsystems.ch.assessment.shared.model.Edge;

public class EdgeOccupancy {

    private final Edge edge;
    private int start;
    private int end;

    public EdgeOccupancy(Edge edge, int start, int end) {

        this.edge = edge;
        this.start = start;
        this.end = end;
    }

    public Edge getEdge() {
        return edge;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "[" + edge + ":" + start + "-" + end + "]";
    }

    public void moveEnd() {
        end++;
    }

    public void moveStart() {
        start++;
    }
}
