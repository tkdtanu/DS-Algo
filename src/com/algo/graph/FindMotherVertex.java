package com.algo.graph;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FindMotherVertex extends GraphDFS {
    //Mother Vertex is a vertex form where we can go to all the vertex.
    //1) in Undirected Connected Graph all the vertex are mother vertex
    //2) in a directed/undirected disconnected graph there will not be any mother vertex
    //3) in a directed connected graph we may have 1 or more mother vertex


    public static void main(String[] args) {
        Graph graph = createDirectedGraph();

        findMotherVerticesByNaiveApprach(graph);
        System.out.println("\n\n\n");

        graph.resetAllVerticesToUnVisited();
        findMotherVerticesByDFSLasVisitedapprach(graph);
        System.out.println("\n\n\n");

        graph = createDirectedGraphWithoutMotherVertex();
        findMotherVerticesByDFSLasVisitedapprach(graph);
    }

    private static void findMotherVerticesByDFSLasVisitedapprach(Graph graph) {

        List<Vertex<Integer>> allVertices = graph.getAllVerticesObj();

        Vertex<Integer> lasFinishedVertex = null;
        LocalDateTime beforeExecute = LocalDateTime.now();

        for (Vertex<Integer> ver : allVertices) {
            if (!ver.isVisited()) {
                System.out.println("DFS doing on vertex:" + ver.getData());
                dFSUtil(ver, graph);
                lasFinishedVertex = ver;
            }

        }

        graph.resetAllVerticesToUnVisited();

        //Make Sure this one is mother vertex
        dFSUtil(lasFinishedVertex, graph);
        boolean allVerticesVisited = graph.isAllVerticesVisited();
        if (!allVerticesVisited) {
            System.out.println("There is no mother vertex in the given graph");
        } else {
            System.out.println("Mother Verices Found :" + lasFinishedVertex.getData());
        }

        LocalDateTime afterExecute = LocalDateTime.now();
        System.out.println("Time Taken to Find Mother Vertices Using Last Visited Node in DFS Approach:" + Duration.between(beforeExecute, afterExecute).toMillis());
    }

    private static void dFSUtil(Vertex<Integer> vertex, Graph graph) {
        vertex.setVisited(true);
        List<Vertex<Integer>> vertexList = graph.getAdjVertices(vertex);
        ListIterator<Vertex<Integer>> iterator = vertexList.listIterator();
        while (iterator.hasNext()) {
            Vertex<Integer> nextVertex = iterator.next();
            if (!nextVertex.isVisited()) {
                dFSUtil(nextVertex, graph);
            }
        }
    }

    /*
     *Apprach
     *We can do DFS on each vertices to find whether we are able to reach to all other vertices.
     * But that will be o(V(E+V)) which is very inefficient
     */
    private static void findMotherVerticesByNaiveApprach(Graph graph) {
        Set<Integer> allVertices = graph.getAllVertices();
        Integer noOfVertices = graph.getNoOfVertices();
        boolean foundMotherVertex = false;

        LocalDateTime beforeExecute = LocalDateTime.now();

        for (Integer ver : allVertices) {
            System.out.println("DFS doing on vertex:" + ver);
            Integer noOfVerticesVisited = doDFSOnGrap(graph, ver);
            graph.resetAllVerticesToUnVisited();
            if (noOfVerticesVisited == noOfVertices) {
                System.out.println("Mother Verices Found :" + ver);
                foundMotherVertex = true;
                break;
            }

        }
        if (!foundMotherVertex) {
            System.out.println("There is no mother vertex in the given graph");
        }

        LocalDateTime afterExecute = LocalDateTime.now();
        System.out.println("Time Taken to Find Mother Vertices Using Naive Approach:" + Duration.between(beforeExecute, afterExecute).toMillis());

    }


    protected static Graph createDirectedGraphWithoutMotherVertex() {
        Graph graph = new Graph(7, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(5, 2);
        graph.addEdge(6, 4);
        graph.addEdge(6, 0);
        return  graph;
    }


}
