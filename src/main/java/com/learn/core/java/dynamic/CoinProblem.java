package com.learn.core.java.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Meetansh on 16-07-2016.
 */
public class CoinProblem {

    private static int count(int coins[],int m, int n){
        if(n==0){
            return 1;
        } else if(n<1){
            return  0;
        }
        if(m<=0 && n>=1){
            return 0;
        }
        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count( coins, m - 1, n ) + count( coins, m, n-coins[m-1] );
    }

    public static void main(String... s){
        //System.out.println(count(new int[]{1,2,3}, 3 , 4));
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            if (line==null){
                return;
            }
            String[] arr = line.trim().split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            if (n < 1 || n > 250 || m < 1 || m > 50) return;

            int a[] = new int[m];
            line = br.readLine();
            if (line==null){
                return;
            }
            arr = line.trim().split(" ");
            if(arr.length<m){
                return ;
            }
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            System.out.println(count(a, m, n));
        }catch (Exception e){
            System.out.println(0);
        }finally {


        }
    }

}
