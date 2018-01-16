package com.tsystems.ch.assessment.meldunggenerator.model;

import com.tsystems.ch.assessment.shared.model.Edge;

import java.util.LinkedList;
import java.util.List;

public class Train {

    private final String name;
    private final LinkedList<EdgeOccupancy> edgeOccupancies;

    public Train(String name, List<EdgeOccupancy> edgeOccupancies) {
        this.name = name;
        this.edgeOccupancies = new LinkedList(edgeOccupancies);
    }

    public int remainingTail() {
        EdgeOccupancy last = edgeOccupancies.get(edgeOccupancies.size() - 1);
        return last.getEdge().getLength() - last.getStart();
    }

    public int remainingHead() {
        EdgeOccupancy head = edgeOccupancies.iterator().next();
        return head.getEdge().getLength() - head.getEnd();
    }

    private Edge leaveEdge() {
        return edgeOccupancies.removeLast().getEdge();
    }

    public Edge enterEdge(Edge edge) {
        edgeOccupancies.addFirst(new EdgeOccupancy(edge, 0, 1));
        return moveTail();
    }

    private Edge moveTail() {
        if (remainingTail() == 1) {
            return leaveEdge();
        } else {
            edgeOccupancies.getLast().moveStart();
            return null;
        }
    }

    public Edge move() {
        edgeOccupancies.getFirst().moveEnd();
        return moveTail();
    }

    @Override
    public String toString() {
        return "T(" + name + "(" + edgeOccupancies + "))";
    }

    public Edge getHead() {
        return edgeOccupancies.getFirst().getEdge();
    }

}
