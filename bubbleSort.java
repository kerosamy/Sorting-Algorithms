import java.util.ArrayList;

import java.util.List;

class ON2Sort  {
    public void sort(List<Integer> arr, boolean printSteps) {
        int n = arr.size();

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

            if (printSteps) {
                System.out.println("Step " + (i + 1) + ": " + arr);
            }
            if (!swapped) break;
        }
        if (!printSteps) {
            System.out.println(arr);
        }
    }
}
