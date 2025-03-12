import java.util.ArrayList;

public class QuickSort {
    private ArrayList<ArrayList<Integer>> Steps;
    public ArrayList<Integer> Arr;

    private void swap(int i, int j) {
        int temp = Arr.get(i);
        Arr.set(i, Arr.get(j));
        Arr.set(j, temp);
    }

    private int partition(int first, int last) {
        int i = first;
        int j = last;
        int pivot = first;
        while (true) {
            while (Arr.get(pivot) <= Arr.get(j) && pivot != j) j--;

            if (pivot == j) break;

            else if (Arr.get(pivot) > Arr.get(j)) {
                swap(pivot, j);
                pivot = j;
            }
            while (Arr.get(pivot) >= Arr.get(i) && pivot != i) i++;

            if (pivot == i) break;
            else if (Arr.get(pivot) < Arr.get(i)) {
                swap(pivot, i);
                pivot = i;
            }
        }
        return pivot;
    }
    private void solve(int start, int end) {
        if (end > start) {
            int pivot = partition(start, end);
            solve(start, pivot - 1);
            solve(pivot + 1, end);
        }
    }
    public void quickSort(ArrayList<Integer> array, int n) {
        this.Arr = array;
        solve(0, n - 1);
    }
}
