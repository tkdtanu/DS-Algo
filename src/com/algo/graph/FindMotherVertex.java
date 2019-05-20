package com.algo.graph;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FindMotherVertex extends GraphDFS {
    //Mother Vertex is a vertex form where we can go to all the vertex.
    //1) in Undirected Connected Graph all the vertex are mother vertex
    //2) in a directed/undirected disconnected graph there will not be any mother vertex
    //3) in a directed connected graph we may have 1 or more mother vertex


    public static void main(String[] args) {
        LocalDateTime beforeExecute = LocalDateTime.now();
        findMotherVerticesByNaiveApprach();
        LocalDateTime afterExecute = LocalDateTime.now();
        System.out.println("Time Taken to Find Mother Vertices Using Naive Approach:" + Duration.between(beforeExecute, afterExecute).toMillis());

    }

    /*
     *Apprach
     *We can do DFS on each vertices to find whether we are able to reach to all other vertices.
     * But that will be o(V(E+V)) which is very inefficient
     */
    private static void findMotherVerticesByNaiveApprach() {
        Graph graph = createDirectedGraph();
        Set<Integer> allVertices = graph.getAllVertices();
        Integer noOfVertices = graph.getNoOfVertices();
        boolean foundMotherVertex = false;

        for (Integer ver : allVertices) {
            System.out.println("DFS doing on vertex:"+ ver);
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

    }


}
