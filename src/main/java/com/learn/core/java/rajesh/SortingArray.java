package com.learn.core.java.rajesh;

import java.util.Arrays;
import java.util.Comparator;

class ImageDetails {
    int time;
    String image;
}

class SortByCost implements Comparator<ImageDetails> {
    public int compare(ImageDetails a, ImageDetails b) {
        if ( a.time < b.time) return -1;
        else if ( a.time == b.time) return 0;
        else return 1;
    }
}

public class SortingArray {

    public static void main(String a[]){




        int [] value = {3,5,2,1,8};
        String [] imageArray={"image3","image5","image2","image1","image8"};
        ImageDetails[] image1 =new ImageDetails[5];

        for(int i=0;i<imageArray.length;i++){
            ImageDetails im = new ImageDetails();
            im.image=imageArray[i];
            im.time =value[i];

            image1[i] =im;

        }
        for(int i=0;i<imageArray.length;i++){
                System.out.println(image1[i].time +"-"+image1[i].image);


        }
        Arrays.sort(image1,new SortByCost());

        System.out.println("After sorting");

         for (int i = 0; i < image1.length; i++) {
            System.out.println(image1[i].time +"-"+image1[i].image);
        }
    }
}
