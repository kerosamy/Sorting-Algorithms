import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] input = {1, 2, 4, 1, -1, 10, 100, -11, -2};
        for (int num : input) {
            arr.add(num);
        }
        q.quickSort(arr, arr.size());
        System.out.println(q.Arr);
    }
}