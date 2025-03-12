import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ONSort implements SortingStrategy {
    public int countDigits(int n) {
        int digits =0 ;
        while (n>0) {
            n /= 10;
            digits++;
        }
        return digits;
    }
    public List<Integer>  countingSort(List<Integer> arr, int digit) {

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
    public void sort(List<Integer> arr , boolean stepByStep) {
        int n = arr.size();
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
            List<Integer> pos = new ArrayList<>();
            List<Integer> neg = new ArrayList<>();
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
                    for ( j = 0; j <NumOfNeg; j++) {
                        System.out.print(neg.get(neg.size()-j-1)*-1+" ");
                    }
                    for ( j = 0; j <NumOfPos; j++) {
                        System.out.print(pos.get(j)+" ");
                    }
                    System.out.println();
                }
            }
            for (int i = y; i < x; i++) {
                if (digits> digits2) pos = countingSort(pos, i);
                else neg = countingSort(neg, i);
                if (stepByStep && i != digits-1) {
                    for ( j = 0; j <NumOfNeg; j++) {
                        System.out.print(neg.get(neg.size()-j-1)*-1+" ");
                    }
                    for ( j = 0; j <NumOfPos; j++) {
                        System.out.print(pos.get(j)+" ");
                    }
                    System.out.println();
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
                    for (int j = 0; j <n; j++) {
                        System.out.print(arr.get(j)+" ");
                    }
                    System.out.println();
                }
            }
        }
        for (int j = 0; j <n; j++) {
            System.out.print(arr.get(j)+" ");
        }
    }
}
