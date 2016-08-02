package com.learn.core.java.graph;
import javafx.util.Pair;

import java.util.*;
/**
 * Created by Admin on 09-07-2016.
 */
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.


// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists


    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }


    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        int startingNode = s;
        int[] edges ;
        edges = new int[V];
        for (int i=0; i<V; ++i){
            edges[i] = -1;
        }
        LinkedList<Integer> connectedNodes = new LinkedList<>();

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

        for(int i=0;i<V;i++){
            if(i==startingNode)
                continue;
            System.out.print(i + ":" + edges[i]+ " ");

        }

    }

    // Driver method to
    public static void main(String args[])
    {

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0,3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(0);
        //Skipping start element


    }

    static void takeInputs(){
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
        int M = 0 , N=0;
         for(int testcase = 0; testcase < n-1 ; testcase ++){
             N = in.nextInt();
             M = in.nextInt();
             Graph g = new Graph(N);
             int arr[] = new int[n];
             for(int arr_i=0; arr_i < n; arr_i++) {
                 arr[arr_i] = in.nextInt();
             }

         }

    }

}
// This code is contributed by Aakash Hasija