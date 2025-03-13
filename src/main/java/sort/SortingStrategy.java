package sort;

import java.util.ArrayList;


public interface SortingStrategy {
    ArrayList<Integer> sort(ArrayList<Integer>  arr, boolean stepByStep);
}