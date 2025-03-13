package sort;

import java.util.ArrayList;

public class ONlogNSort implements SortingStrategy {
    public ArrayList<Integer> Arr;
    private ArrayList<Boolean> vis;
    private Boolean steps  ;
    private int counter;

    private void swap(int i, int j) {
        int temp = Arr.get(i);
        Arr.set(i, Arr.get(j));
        Arr.set(j, temp);
    }
    private int medianOfThree(int first, int last) {
        int mid = first + (last - first) / 2;

        if (Arr.get(mid) < Arr.get(first)) swap(mid, first);
        if (Arr.get(last) < Arr.get(first)) swap(last, first);
        if (Arr.get(last) < Arr.get(mid)) swap(last, mid);
        swap(mid, last-1);
        return last-1;
    }

    private int partition(int first, int last) {
        int pivot = medianOfThree(first, last);
        int i = first ;
        int j = pivot;
        while (true) {
            while (Arr.get(pivot) >= Arr.get(i) && pivot != i) i++;
            if (pivot == i) break;
            else if (Arr.get(pivot) < Arr.get(i)) {
                swap(pivot, i);
                pivot = i;
            }
            while (Arr.get(pivot) <= Arr.get(j) && pivot != j) j--;
            if (pivot == j) break;
            else if (Arr.get(pivot) > Arr.get(j)) {
                swap(pivot, j);
                pivot = j;
            }
        }
        vis.set(i, true);
        return pivot;
    }
    private void solve(int start, int end) {
        if (end > start) {
            if(steps&&counter!=0){
                printArray.printStep(counter, Arr, vis);
                counter++;
            }
            if(counter==0)counter++;


            int pivot = partition(start, end);
            solve(start, pivot - 1);
            solve(pivot + 1, end);
        }
    }
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer>  arr, boolean stepByStep) {
        this.Arr = arr;
        this.counter=0;
        this.steps = stepByStep ;
        this.vis = new ArrayList<>(Arr.size());
        for (int i = 0; i < Arr.size(); i++) {
            this.vis.add(false);
        }
        printArray.printFristArray(arr);
        solve(0, arr.size() - 1);
        printArray.printSortedArray(arr);
        return arr;
    }

}
