package com.learn.core.java.graph;

import java.util.*;
/**
 * Created by Admin on 09-07-2016.
 */
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.


// This class represents a directed graph using adjacency list
// representation
public class Graph
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
    int getVertexcount()  {
        return V;
    }
    public LinkedList<Integer>[] getAdj(){
        return adj;
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