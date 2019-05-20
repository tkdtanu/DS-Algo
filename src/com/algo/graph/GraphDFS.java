package com.algo.graph;

import java.util.List;
import java.util.Stack;

public class GraphDFS {
    public static void main(String[] args) {

        Graph graph = createGraph();
        doDFSOnGrap(graph, 0);
    }

    protected static int doDFSOnGrap(Graph graph, int sourceVertex) {
        System.out.print("Start-->");
        if (graph == null || graph.getVertex(sourceVertex) == null)
            throw new RuntimeException("Empty Graph");
        int noOfVisitedVertices = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(sourceVertex);

        //untill stack is emplty iterate  it
        while (!stack.empty()) {
            Integer vertex = stack.pop();
            Vertex vertexObject = graph.getVertex(vertex);
            if (!vertexObject.isVisited()) {

                System.out.print(vertex + "-->");
                vertexObject.setVisited(true);
                noOfVisitedVertices++;

                List<Vertex<Integer>> vertexList = graph.getAdjVertices(vertex);

                for (Vertex<Integer> v : vertexList) {
                    stack.push(v.getData());
                }
            }

        }
        System.out.println("End");
        return noOfVisitedVertices;
    }


    protected static Graph createGraph() {
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

    protected static Graph createDirectedGraph() {
        Graph graph = new Graph(7, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        graph.addEdge(6, 0);
        return  graph;
    }
}
