import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ON2Sort N = new ON2Sort();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] input = {1, 2, 4, 1, -1, 10, 100, -11, -2};
        for (int num : input) {
            arr.add(num);
        }
        N.sort(arr,true);
    }
}