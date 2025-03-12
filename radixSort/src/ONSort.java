import java.util.LinkedList;
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
    public int[] countingSort(int[] arr, int digit) {

        Queue<Integer>[] queues = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = 0; j < digit; j++) {
                num /= 10;
            }
            queues[num%10].add(arr[i]);
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            while (!queues[i].isEmpty()) {
                arr[index++] = queues[i].remove();
            }
        }
        return arr;
    }
    public void sort(int[] arr , boolean stepByStep) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int NumOfPos=0;
        int NumOfNeg=0;
        for (int i = 0; i < n; i++) {
            if (arr[i]> max ) max = arr[i];
            if (arr[i]< min ) min = arr[i];
            if (arr[i] >= 0) NumOfPos++;
            else NumOfNeg++;
        }
        int digits = countDigits(max);
        if (min <0){
            int digits2 = countDigits(Math.abs(min)) ,k =0 , j=0 ;
            int pos[] = new int[NumOfPos];
            int neg[] = new int[NumOfNeg];
            for (int i = 0; i < n; i++) {
                if (arr[i]>=0) pos[k++] = arr[i];
                else neg[j++] = (arr[i])*-1;
            }
            int x = Math.max(digits, digits2);
            int y = Math.min(digits, digits2);
            for (int i = 0; i < y; i++) {
                pos= countingSort(pos, i);
                neg = countingSort(neg, i);
                if (stepByStep && i != digits-1) {
                    for ( j = 0; j <NumOfNeg; j++) {
                        System.out.print(neg[neg.length-j-1]*-1+" ");
                    }
                    for ( j = 0; j <NumOfPos; j++) {
                        System.out.print(pos[j]+" ");
                    }
                    System.out.println();
                }
            }
            for (int i = y; i < x; i++) {
                if (digits> digits2) pos = countingSort(pos, i);
                else neg = countingSort(neg, i);
                if (stepByStep && i != digits-1) {
                    for ( j = 0; j <NumOfNeg; j++) {
                        System.out.print(neg[neg.length-j-1]*-1+" ");
                    }
                    for ( j = 0; j <NumOfPos; j++) {
                        System.out.print(pos[j]+" ");
                    }
                    System.out.println();
                }
            }
            int index = 0;
            for (int i = 0; i < neg.length; i++) {
                arr[index++] = neg[neg.length-i-1]*-1;
            }
            for (int i = 0; i < pos.length; i++) {
                arr[index++] = pos[i];
            }
        }
        else {

            for (int i = 0; i < digits; i++) {
                arr= countingSort(arr, i);
                if (stepByStep && i != digits-1) {
                    for (int j = 0; j <n; j++) {
                        System.out.print(arr[j]+" ");
                    }
                    System.out.println();
                }
            }
        }
        for (int j = 0; j <n; j++) {
            System.out.print(arr[j]+" ");
        }
    }
}
