import java.util.ArrayList;
import java.util.Random;


import java.util.List;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        ONlogNSort q = new ONlogNSort();
        ON2Sort q2 = new ON2Sort();
        ONSort q3 = new ONSort();
        int[] arr0 = {100,200,-1,-99,0,6,1000};
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        for (int i = 0; i < arr0.length; i++) {
           arr.add(arr0[i]);
           arr2.add(arr0[i]);
           arr3.add(arr0[i]);
        } 
        q.sort(arr, true); 
        System.out.println("--------------------");
        q2.sort(arr2, true);
        System.out.println("--------------------");
        q3.sort(arr3, true);
       
    }
}
