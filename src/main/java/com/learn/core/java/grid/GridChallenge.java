package com.learn.core.java.grid;


import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Meetansh on 09-07-2016.
 */
public class GridChallenge {

    public static void main(String args[])
    {
        solveSolution();
    }

    static void sortString(char[][] grid,int row) {
        //System.out.println(new StringS(grid[row]));
        char temp;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length - 1 - i; j++) {
                if (grid[row][j] > grid[row][j+1]) {
                    temp = grid[row][j+1];
                    grid[row][j+1] = grid[row][j];
                    grid[row][j] = temp;
                }
            }
        }
        //System.out.println(new StringS(grid[row]));
    }

    static boolean checkGridIsValid(char[][] grid,int firstrow, int secondrow){
        if(!(firstrow<grid.length && secondrow < grid.length )) {
            return false;
        }
        boolean isValid = true;
        for(int i=0; i<grid.length ; i++) {
            isValid = isValid & grid[firstrow][i]<=grid[secondrow][i];
            if(!isValid){
                return false;
            }
        }
        return isValid;
    }

    static void solveSolution(){
       /* StringS input ="1\n" +
                "5\n" +
                "ebacd\n" +
                "fghij\n" +
                "olmkn\n" +
                "trpqs\n" +
                "xywuv";*/
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new InputStreamReader(new BufferedInputStream(new ByteArrayInputStream(inputs.getBytes()))));
        int t = in.nextInt();
        System.out.println(t);
        List result = new ArrayList();


        for(int testcase = 0; testcase < t ; testcase++){
            int N = in.nextInt();
            System.out.println(N);
            char grid[][]=new char[N][N];
            in.nextLine();
            for(int i=0 ; i<N; i++){
                grid[i]=in.nextLine().trim().toCharArray();
            }

            boolean isValid = true;
            sortString(grid,0);
            for(int i=1 ; i<N; i++){
                sortString(grid,i);
                if(!checkGridIsValid(grid,i-1,i)){
                    isValid = false;
                    break;
                }
            }
            result.add((isValid) ? "YES" : "NO");
        }
        for(int testcase = 0; testcase < t ; testcase++) {
            System.out.println(result.get(testcase));
        }

    }

}
