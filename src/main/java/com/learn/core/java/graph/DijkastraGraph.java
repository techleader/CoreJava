package com.learn.core.java.graph;

import com.learn.core.java.tree.StringS;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by Admin on 09-07-2016.
 */
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.


// This class represents a directed graph using adjacency list
// representation
class DijkastraGraph
{
    private int V;   // No. of vertices
    private LinkedList<Pair> adj[]; //Adjacency Lists


    // Constructor
    DijkastraGraph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w, int weight)
    {
        Pair pair = new Pair(w,weight);
        adj[v].add(pair);
        pair = new Pair(v,weight);
        adj[w].add(pair);
    }


    // prints BFS traversal from a given source s
    void findShortestPath(int s)
    {
        int startingNode = s;
        LinkedList<Integer> connectedNodes = new LinkedList<>();

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
        int updatedWight[] = new int[V];
        for(int i=0; i<updatedWight.length; i++){
            updatedWight[i] = Integer.MAX_VALUE;
        }

        // Create a queue for BFS
        Set<Integer> queue = new HashSet<>();

        // Mark the current node as visited and enqueue it
        queue.add(s);
        updatedWight[s] = 0;

        while (queue.size() >0)
        {
            // Dequeue a vertex from queue and print it
            s= findNodeWithMinimunEdge(updatedWight,visited);
            connectedNodes.add(s);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Pair> i = adj[s].listIterator();
            while (i.hasNext())
            {
                Pair pair = i.next();
                int connectednode = (Integer) pair.getKey();
                if (!visited[connectednode])
                {
                    int distance =updatedWight[s] + (Integer) pair.getValue();
                    if(distance<updatedWight[connectednode]){
                        updatedWight[connectednode] = distance;
                    }
                    queue.add(connectednode);
                }
            }
            visited[s] = true;
            queue.remove(new Integer(s));
        }

        for(int i=0;i<V;i++){
            if(i==startingNode)
                continue;
            System.out.print( updatedWight[i]+ " ");

        }

    }

    int findNodeWithMinimunEdge(int[] weight, boolean[] visited ){
        int min = Integer.MAX_VALUE, min_index=-1;
        for (int v = 0; v < V; v++)
            if (visited[v] == false && weight[v] <= min)
            {
                min = weight[v];
                min_index = v;
            }
        return min_index;
    }

    // Driver method to
    public static void main(StringS args[])
    {
        int c[] ={4,5,3,8,3,7};
        System.out.println(minArray(c));
    }

    int min;
    static int minArray(int[] arr) {
        if(arr==null || arr.length==0) {
            return 0;
        }
        LinkedList<Integer> allowed = new LinkedList<>();
        int min=arr[0];
        allowed.add(arr[0]);
        int maxAllowed=min*2;
        int itemsToBeRemoved = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
                maxAllowed = min*2;
                itemsToBeRemoved+= removeNotAllowed(allowed,maxAllowed);
            }
            if (arr[i]>maxAllowed){
                itemsToBeRemoved++;
            } else {
                allowed.add(arr[i]);
            }
        }
        itemsToBeRemoved+= removeNotAllowed(allowed,maxAllowed);
        return itemsToBeRemoved;
    }

    private static int removeNotAllowed(LinkedList<Integer> allowed,int max){
        int itemsToBeRemoved=0;
        while (allowed.size()>0){
            int no = allowed.peek();
            if(no>max){
                allowed.poll();
                itemsToBeRemoved++;
            }
        }
        return itemsToBeRemoved;
    }


    static int getCount(int[] A, int S) {
        int [] coins= new int[S+1];
        coins[0]=0;

        for(int i=1;i<coins.length;i++)
            coins[i]=Integer.MAX_VALUE;

        for(int i=1;i<=S;i++)
            for(int j=0;j<A.length;j++)
                if((A[j]<=i) && (coins[i-A[j]]+1<coins[i]))
                    coins[i]=coins[i-A[j]]+1;
        return coins[S];

    }

   /* static void solveSolution(){
        //StringS inputs = "1 4 4 1 2 24 1 4 20 3 1 3 4 3 12 1";
       // StringS inputs = "2 4 4 1 2 24 1 4 20 3 1 3 4 3 12 1 4 4 1 2 24 1 4 20 3 1 3 4 3 12 2";
        //StringS inputs = "2 4 4 1 2 24 1 4 20 3 1 3 4 3 12 1 4 4 1 2 24 1 4 20 3 1 3 4 3 12 2";
        StringS inputs = "1 9 14 1 2 4 1 8 8 2 3 8 2 8 11 8 9 7 8 7 1 3 9 2 9 7 6 3 6 4 7 6 2 3 4 7 6 5 10 6 4 14 4 5 9 1";
         //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new InputStreamReader(new BufferedInputStream(new ByteArrayInputStream(inputs.getBytes()))));
         int n = in.nextInt();
        int M = 0 , N=0;
         for(int testcase = 0; testcase < n ; testcase ++){
             N = in.nextInt();
             M = in.nextInt();
             DijkastraGraph g = new DijkastraGraph(N);
             for(int i=0 ; i<M; i++){
                 int from = in.nextInt();
                 int to = in.nextInt();
                 int weight = in.nextInt();
                 g.addEdge(from-1,to-1,weight);
             }
             int startNode = in.nextInt();
             g.findShortestPath(startNode-1);
             System.out.println();
         }

    }*/

}
// This code is contributed by Aakash Hasija