package com.learn.core.java.grid;

import com.learn.core.java.string.DNASequence;

import java.util.LinkedList;

/**
 * Created by Meetansh on 09-07-2016.
 */
public class Maze {
    private static int ROW=3;
    private static int COL=3;
    private static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    static class Point{
        int x;
        int y;
        int dist;
        Point(int x, int y,int dist){
            this.x= x;
            this.y = y;
            this.dist = dist;
        }
    }



    private static int runMaze(int startX, int startY, int endX, int endY, int[][] maze) {
        // Add your code here
        if(maze==null){
            return 0;
        }
        if(startX>=ROW || startY>=COL || endX>=ROW || endY>=COL){
            return -1;
        }

        if (maze[startX][startY] == 1 || maze[endX][endY] == 1) {            //No Path
            return -1;
        }
        if (maze[startX][startY] == 1 || maze[endX][endY] == 1) {            //No Path
            return -1;
        }
        LinkedList<Point> queue = new LinkedList<Point>();
        ROW = maze.length;
        COL = maze[0].length;
        boolean visitedNodes[][] = new boolean[ROW][COL];
        visitedNodes[startX][startY] = true;
        Point point = new Point(startX, startX, 0);
        queue.add(point);

        while (queue.size() > 0) {
            Point p = queue.pollFirst();;
            if (p.x == endX && p.y == endY) {
                return p.dist;
            }

            for (int i = 0; i < 4; i++) {
                int row = p.x + rowNum[i];
                int col = p.y + colNum[i];
                if (isValid(row, col) && maze[row][col] == 0 && !visitedNodes[row][col]) {
                    visitedNodes[row][col] = true;
                    Point newp = new Point(row, col, p.dist + 1);
                    queue.add(newp);
                }

            }
        }
        return -1;
    }

    static boolean isValid(int row, int col){
        return (row>=0 && (row < ROW ) && (col>=0 && col< COL));
    }

    public static void main(String... s){
        int maze[][] = { {0,1,0},{0,0,0},{1,1,0}};
         int value= runMaze(0,0,0,2,maze);
        System.out.println("Value "+ value);
    }

}
