package com.learn.core.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckDuplicateNumberInArray {

    public static void main(String[] args) {

        int a[] = {8965, 8966, 8965, 8966, 5642};
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0, count = 1;
        String flag = "false";


        for (int i = 0; i < a.length; i++) {
            num = a[i];
            flag = "false";
            for (Map.Entry m : map.entrySet()) {

                if (m.getKey().equals(num)) {

                    flag = "true";
                }
            }
            if (flag == "true") {
                continue;
            }
            for (int j = i + 1; j < a.length; j++) {

                if (num == a[j]) {
                    count++;
                }
            }
            map.put(num, count);
            count = 1;
        }


        List<Integer> trainnumbers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {

            if (m.getValue().equals(2))

                trainnumbers.add(m.getKey());

        }

        for (int n : trainnumbers) {
            System.out.println(n);
        }

    }
}

