package com.learn.core.java.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Meetansh on 26-08-2016.
 */
public class GraphTraversalUtil {

    public void traverseBFSWithRecursion(int source){

    }

    public static void traverseBFSWithRecursion(Graph graph,int s){
        int V = graph.getVertexcount();
        boolean visited[] = new boolean[V];
        visitGraph(s,graph,visited);
    }

    private static void visitGraph(int s,Graph graph,boolean visited[]){
        visited[s] = true;
        System.out.print(s + " => ");
        Iterator<Integer> i = graph.getAdj()[s].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
            {
                visitGraph(n,graph,visited);
            }
        }

    }

    public static void traverseBFSWithIteration(Graph graph,int s){
        int V = graph.getVertexcount();
        int startingNode = s;
        int[] edges ;
        edges = new int[V];
        for (int i=0; i<V; ++i){
            edges[i] = -1;
        }
        LinkedList<Integer> connectedNodes = new LinkedList<>();
        LinkedList<Integer> adj[] = graph.getAdj();

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " => ");
            connectedNodes.add(s);
            edges[s] = 6;


            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
        System.out.println(String.format("Distance from vertext %s => ",s ));
        for(int i=0;i<V;i++){
            if(i==startingNode)
                continue;
            System.out.print(i + ":" + edges[i]+ " ");

        }
    }
}
