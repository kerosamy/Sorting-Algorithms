package sort;

import java.util.ArrayList;

public class ON2Sort implements SortingStrategy {


    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arr, boolean printSteps) {
        int n = arr.size();
        ArrayList<Boolean> vis = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            vis.add(false);
        }
        printArray.printFristArray(arr);
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            vis.set(n-1-i, true);
            if (printSteps) {
                printArray.printStep(i+1, arr, vis);
            }
            if (!swapped) break;
        }
        printArray.printSortedArray(arr);
        return arr;
    }

}
