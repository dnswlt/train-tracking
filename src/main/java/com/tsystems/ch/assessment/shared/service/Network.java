package com.tsystems.ch.assessment.shared.service;

import com.tsystems.ch.assessment.shared.model.Edge;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class Network {

    private Map<String, Edge> edges = new HashMap<>();
    private Map<Integer, List<Edge>> graph = new HashMap<>();

    @PostConstruct
    public void init() {
        addEdge(e(1, 2, 10));
        addEdge(e(2, 3, 10));
        addEdge(e(3, 4, 10));
        addEdge(e(4, 5, 5));
        addEdge(e(4, 8, 25));
        addEdge(e(5, 6, 10));
        addEdge(e(6, 7, 10));
        addEdge(e(7, 8, 5));
        addEdge(e(8, 9, 5));
        addEdge(e(9, 10, 10));
        addEdge(e(10, 11, 5));
        addEdge(e(11, 12, 40));
        addEdge(e(12, 13, 5));
        addEdge(e(12, 15, 60));
        addEdge(e(13, 14, 20));
        addEdge(e(14, 15, 15));
        addEdge(e(15, 16, 20));
        addEdge(e(16, 17, 20));
        addEdge(e(17, 18, 10));
        addEdge(e(18, 19, 20));
        addEdge(e(19, 1, 10));
    }

    public Edge getEdge(int from, int to) {
        return edges.get(Edge.id(from, to));
    }

    public Set<Edge> getEdges() {
        return graph.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    private void addEdge(Edge edge) {
        graph.computeIfAbsent(edge.getFrom(), (id) -> new ArrayList<>()).add(edge);
        edges.put(edge.getId(), edge);
    }

    private Edge e(int from, int to, int length) {
        return new Edge(from, to, length);
    }

    public Edge getRandomSuccessor(Edge edge) {
        List<Edge> successors = graph.get(edge.getTo());
        int i = new Random().nextInt(successors.size());
        return successors.get(i);
    }
}
