package com.tsystems.ch.assessment.shared.model;

public class Edge {
    private int from;
    private int to;
    private String id;
    private int length;

    public Edge(int from, int to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
        this.id = id(from, to);
    }

    public static String id(int from, int to) {
        return String.format("%d->%d", from, to);
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (from != edge.from) return false;
        if (to != edge.to) return false;
        if (length != edge.length) return false;
        return id.equals(edge.id);

    }

    @Override
    public int hashCode() {
        int result = from;
        result = 31 * result + to;
        result = 31 * result + id.hashCode();
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return id + "/" + length;
    }
}
