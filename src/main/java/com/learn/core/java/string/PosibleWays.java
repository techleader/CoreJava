package com.learn.core.java.string;


public class PosibleWays {

    public static void main(String[] args) {

    }

    public static int possibleWay(String str) {
        System.out.println("---------------------------");
        if (str == null || str.length() == 0) {
            return 0;
        }
        int totalPossibleWays = 0;
        for (int i = 0; i < str.length(); i++) {
            totalPossibleWays = totalPossibleWays + possibleWay(str, i, 1,1);
        }
        System.out.println(str + " ==> possible ways => " + totalPossibleWays);
        return totalPossibleWays;
    }

    public static int possibleWay(String str, int index, int indentent, int direction) {

        if (str.replace("a", "").equals("")) {
         //   System.out.println(" - 1 possible way...........");
            return 1;
        }
        if(index<1 || index>= str.length()) {
            return 0;
        }
        Character curr = str.charAt(index);
        Character pre = (index - 1 >= 0) ? str.charAt(index - 1) : null;
        Character next = (index + 1 < str.length()) ? str.charAt(index + 1) : null;
        boolean canChange = false;
        boolean canChangeDueToPre = false;
        boolean canChangeDueToNext = false;
        int ways = 0;

        if (curr.equals(Character.valueOf('b'))) {
            if (pre != null && pre.equals(Character.valueOf('a'))) {
                canChange = canChangeDueToPre = true;
            }
            if (next != null && next.equals(Character.valueOf('a'))) {
                canChange = canChangeDueToNext = true;
            }
            if (canChange) {
                String newStr = str.substring(0, index) + "a" + str.substring(index + 1);
                System.out.print(String.format("%"+indentent + "s","."));
                System.out.println(str.substring(0,index) + "[" + str.substring(index, index+1) + "]" + str.substring(index+1) + " ==>" + newStr + " : " + index);
               // System.out.print(String.format("%"+indentent + "s","."));
               // System.out.println(str + " ==> " + newStr + " : " + index);
                if(canChangeDueToPre && canChangeDueToNext) {
                    return 1;
                }
                else if (canChangeDueToPre) {
                   // return possibleWay(newStr);
                  //  ways =  possibleWay(newStr, index+1, indentent+3 ) + possibleWay(str, index+1,indentent+3);
                    //System.out.print(String.format("%"+indentent + "s",""));
                    //System.out.println(newStr + " >> Possible ways next " + ways);
                } else if (canChangeDueToNext) {
                    //return possibleWay(newStr);
                  //  ways = possibleWay(newStr, index-1,indentent+3) + possibleWay(str, index-1,indentent+3);
                   // System.out.print(String.format("%"+indentent + "s","."));
                    //System.out.println(newStr + " >> Possible ways pre " + ways);
                }

                //   possibleWay()
            }  else {
            //    ways = possibleWay(str, index+1, indentent+3);
                //int endIn =
                System.out.print(String.format("%"+indentent + "s","."));
                System.out.println(str.substring(0,index) + "[" + str.substring(index, index+1) + "]" + str.substring(index+1) + " -- No change");
            }

        }  else {
          //  ways = possibleWay(str, index+1, indentent+3);
            System.out.print(String.format("%"+indentent + "s","."));
            System.out.println(str.substring(0,index) + "[" + str.substring(index, index+1) + "]" + str.substring(index+1) + " -- No change");
        }
        return ways;
    }



    public void test() {
        /*Assert.assertEquals(0, possibleWay("bbbbb"));
        Assert.assertEquals(1, possibleWay("bbbba"));*/
      //  Assert.assertEquals(1, possibleWay("abbba"));
    }

}
