package com.learn.core.java.dynamic;

//TODO incomplete
public class TotalNoOfWayToFormN {
    public static void main(String[] args) {

        for(int i = 0; i<10; i++) {
            StringBuffer c1 = new StringBuffer();
            StringBuffer c2 = new StringBuffer();
            int result = solve(i,c2, c1);
            System.out.println(String.format("Final Result for %d : %d" ,i, result));
            System.out.println(String.format("Combinations : %s" ,c1.toString()));
        }
    }



    private static int solve(int n, StringBuffer ch, StringBuffer sb) {
        if(n<0) {
            return 0;
        }
       /* if(!ch.toString().isEmpty()){
            sb.append(ch);
            if(!sb.toString().endsWith("+")) {
                sb.append("+");
            }
        }*/
        if(n==0) {
            sb.append(ch);
            return 1;
        }

        int n1 = solve(n-1,ch.append("1+"),sb);
        int n2 = solve(n-3, ch.append("3+"), sb);
        int n3 = solve(n-5, ch.append("5+") , sb);
        if(!sb.toString().endsWith(", ")){
            sb.append(", ");
        }
        int s = n1 + n2 + n3;
     //   System.out.println(String.format("Combination for %d => %d, %d, %d = %d", n,n1,n2,n3,s));
        return s;
    }
}
