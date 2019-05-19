package com.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
    public static void main(String[] args) {

        Graph graph = createGraph();
        doDFSOnGrap(graph, 0);
    }

    private static void doDFSOnGrap(Graph graph, int sourceVertex) {
        System.out.print("Start-->");
        if (graph == null || graph.getVertex(sourceVertex) == null)
            throw new RuntimeException("Empty Graph");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);

        //untill stack is emplty iterate  it
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            Vertex vertexObject = graph.getVertex(vertex);
            if (!vertexObject.isVisited()) {

                System.out.print(vertex + "-->");
                vertexObject.setVisited(true);

                List<Vertex<Integer>> vertexList = graph.getAdjVertices(vertex);

                for (Vertex<Integer> v : vertexList) {
                    queue.add(v.getData());
                }
            }

        }
        System.out.print("End");
    }

    private static Graph createGraph() {
        Graph graph = new Graph(9, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(7, 8);
        graph.addEdge(7, 6);
        graph.addEdge(8, 2);
        graph.addEdge(8, 6);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        return graph;

    }
}
