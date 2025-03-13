package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ONSort implements SortingStrategy {
    private ArrayList<Boolean> vis;
    private int counter  ;
    public int countDigits(int n) {
        int digits =0 ;
        while (n>0) {
            n /= 10;
            digits++;
        }
        return digits;
    }
    public ArrayList<Integer>  countingSort(ArrayList<Integer> arr, int digit) {

        Queue<Integer>[] queues = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            for (int j = 0; j < digit; j++) {
                num /= 10;
            }
            queues[num%10].add(arr.get(i));
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            while (!queues[i].isEmpty()) {
                arr.set(index, queues[i].remove());
                index ++;
            }
        }
        return arr;
    }
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arr , boolean stepByStep) {
        int n = arr.size();
        this.counter=1;
        this.vis = new ArrayList<>(n);
        for (int i = 0; i <n; i++) {
            this.vis.add(false);
        }
        printArray.printFristArray(arr);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int NumOfPos=0;
        int NumOfNeg=0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i)> max ) max = arr.get(i);
            if (arr.get(i)< min ) min = arr.get(i);
            if (arr.get(i) >= 0) NumOfPos++;
            else NumOfNeg++;
        }
        int digits = countDigits(max);
        if (min <0){
            int digits2 = countDigits(Math.abs(min)) ,k =0 , j=0 ;
            ArrayList<Integer> pos = new ArrayList<>();
            ArrayList<Integer> neg = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr.get(i)>=0) pos.add( arr.get(i));
                else neg.add(arr.get(i)*-1);
            }
            int x = Math.max(digits, digits2);
            int y = Math.min(digits, digits2);
            for (int i = 0; i < y; i++) {
                pos= countingSort(pos, i);
                neg = countingSort(neg, i);
                if (stepByStep && i != digits-1) {
                    ArrayList<Integer> step = new ArrayList<>();
                    for ( j = 0; j <NumOfNeg; j++) {
                        step.add(neg.get(neg.size()-j-1)*-1);
                    }
                    for ( j = 0; j <NumOfPos; j++) {
                        step.add(pos.get(j)) ;
                    }
                    printArray.printStepsRadix(step, counter);
                    counter++;
                }
            }
            for (int i = y; i < x; i++) {
                if (digits> digits2) pos = countingSort(pos, i);
                else neg = countingSort(neg, i);
                if (stepByStep && i != digits-1) {
                    ArrayList<Integer> step = new ArrayList<>();
                    for ( j = 0; j <NumOfNeg; j++) {
                        step.add(neg.get(neg.size()-j-1)*-1) ;
                    }
                    for ( j = 0; j <NumOfPos; j++) {
                        step.add(pos.get(j));
                    }
                    printArray.printStepsRadix(step,counter);
                    counter++;
                }
            }
            int index = 0;
            for (int i = 0; i < neg.size(); i++) {
                arr.set(index, neg.get(neg.size()-1-i)*-1);
                index++;
            }
            for (int i = 0; i < pos.size(); i++) {
                arr.set(index, pos.get(i));
                index++;
            }
        }
        else {

            for (int i = 0; i < digits; i++) {
                arr= countingSort(arr, i);
                if (stepByStep && i != digits-1) {
                    printArray.printStep(counter, arr, vis);
                    counter++;
                }
            }
        }
        printArray.printSortedArray(arr);
        return arr ;
    }
}
