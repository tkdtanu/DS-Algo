package com.algo.graph;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graph {
    private int noOfVertices;
    private Map<Integer, List<Vertex<Integer>>> adjVertices = new HashMap<>();
    private final Map<Integer, Vertex<Integer>> verticesMap = new HashMap<>();
    private boolean isDirected;

    public Graph(int noOfVertices, boolean isDirected) {
        this.isDirected = isDirected;
        this.noOfVertices = noOfVertices;
        IntStream.range(0, noOfVertices).forEachOrdered(index -> {
            Vertex vertex = new Vertex(index);
            verticesMap.putIfAbsent(index, vertex);
            adjVertices.putIfAbsent(index, new LinkedList<>());
        });
    }

    public Vertex getVertex(int id) {
        return verticesMap.get(id);
    }

    public List<Vertex<Integer>> getAdjVertices(int vertex) {
        return adjVertices.get(vertex);
    }

    public List<Vertex<Integer>> getAdjVertices(Vertex<Integer> vertex) {
        return adjVertices.get(vertex.getData());
    }

    public void addEdge(int source, int destination) {
        Vertex sourceVertex = verticesMap.get(source);
        Vertex destinationVertex = verticesMap.get(destination);

        if (source == destination || sourceVertex == null || destinationVertex == null) {
            throw new RuntimeException("Source|Destination value is wrong");
        }
        // get the exisiting List and the add the vertex to that
        adjVertices.get(source).add(destinationVertex);

        //Create a Edge between destination and source is based on condition whether it is directed on not
        if (!this.isDirected) {
            adjVertices.get(destination).add(sourceVertex);
        }
    }

    public void removeVertex(int vertex) {
        Vertex vertexObj = new Vertex<>(vertex);
        adjVertices.get(vertexObj).stream().forEach(eachVertex -> {
            adjVertices.get(eachVertex).remove(vertexObj);
        });
        adjVertices.remove(vertexObj);

    }

    public void removeEdge(int source, int destination) {
        Vertex sourceVertex = verticesMap.get(source);
        Vertex destinationVertex = verticesMap.get(destination);

        if (source == destination || sourceVertex == null || destinationVertex == null) {
            throw new RuntimeException("Source|Destination value is wrong");
        }

        List<Vertex<Integer>> v1 = adjVertices.get(source);
        List<Vertex<Integer>> v2 = adjVertices.get(destination);
        v1.remove(destinationVertex);
        if (!this.isDirected) {
            v2.remove(sourceVertex);
        }
    }

    public Set<Integer> getAllVertices() {
        return this.verticesMap.keySet();
    }

    public List<Vertex<Integer>> getAllVerticesObj() {
        return this.verticesMap
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public void resetAllVerticesToUnVisited() {
        this.verticesMap.values().forEach(vertex -> {
            vertex.setVisited(false);
        });
    }

    public boolean isAllVerticesVisited() {
        return this.verticesMap.values().stream().allMatch(vertex -> vertex.isVisited());
    }
}
