package com.learn.core.java.string;



import java.util.*;

/**
 * Created by Admin on 06-07-2016.
 */
public class DNASequence {
    static int ROW;
    static int COL;

    public static void main(String... s) {
        String input = "AGTAGTGGTTAGTAGTTTGGAGTAGTGGTTGTGGTTAGTATTTGGAGTAG";
        findRepeated(input).forEach(System.out::println);

        System.out.println("With Tree");
        StringDuplicateWithTree duplicateWithTree = new StringDuplicateWithTree();
        duplicateWithTree.count(input).forEach(System.out::println);

    }

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

        int rowNum[] = {-1, 0, 0, 1};
        int colNum[] = {0, -1, 1, 0};
        if (maze[startX][startY] == 1 || maze[endX][endY] == 1) {
            //No Path
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
            Point p = queue.removeLast();
            if (p.x == endX && p.y == endY) {
                return p.dist;
            }
            queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int row = p.x + rowNum[i];
                int col = p.y + colNum[i];
                if (isValid(row, col) && maze[row][col] == 0 && !visitedNodes[row][col]) {
                    visitedNodes[row][col] = true;
                    Point newp = new Point(startX, startX, p.dist + 1);
                    queue.add(newp);
                }

            }
        }
        return -1;
    }

        static boolean isValid(int row, int col){
            return (row>=0 && (row < ROW ) && (col>=0 && col< COL));
        }







    public static Set<String> findRepeated(String s) {
        if (s == null || s.length() < 10) {
            return Collections.emptySet();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        int mask = (1 << 20) - 1; //111...11 (20 times)

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < 9) {
                number = (number << 2) + map.get(s.charAt(i));
                System.out.println("i=" + i + ", " + number);
            } else {
                number = (number << 2) + map.get(s.charAt(i));
                System.out.println("i=" + i + ", " + number);
                //make sure number is only 20 bits
                number = number & mask;
                System.out.println("i=" + i + ", Masked no. " + number);

                if (visited.contains(number)) {
                    System.out.println("i=" + i + ", Masked no found in visited. " + number);
                    result.add(s.substring(i - 9, i + 1));
                }
                visited.add(number);
            }
        }

        return result;
    }
    static class StringDuplicateWithTree {

        public List<String> count(String a) {
            Set<String> set = new TreeSet<String>();
            int len = 10;
            List<String> duplicateStrings = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                int endindex = i+len;
                if(endindex >a.length())
                    break;
                String sub = a.substring(i,endindex);
                if(!set.add(sub)){
                    duplicateStrings.add(sub);
                }
            }
            return duplicateStrings;
        }
    }
}


