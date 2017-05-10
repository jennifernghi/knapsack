import java.util.ArrayList;

/**
 * modified Quicksort for sorting descending Item based on their value / weight
 * @author jennifernghinguyen
 *
 */
public class QuickSort {
  public static void quickSort(ArrayList<Item> list) {
    quickSort(list, 0, list.size() - 1);
  }

  private static void quickSort(ArrayList<Item> list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  /** Partition the array list[first..last] */
  private static int partition(ArrayList<Item> list, int first, int last) {
    Item pivot = list.get(first); // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list.get(low).getValuePerWeightRatio() > pivot.getValuePerWeightRatio())
        low++;

      // Search backward from right
      while (low <= high && list.get(high).getValuePerWeightRatio() < pivot.getValuePerWeightRatio())
        high--;

      // Swap two elements in the list
      if (high > low) {
        Item temp = list.get(high);
        list.set(high, list.get(low));
        list.set(low, temp);
      }
    }

    while (high > first && list.get(high).getValuePerWeightRatio() < pivot.getValuePerWeightRatio())
      high--;

    // Swap pivot with list[high]
    if (pivot.getValuePerWeightRatio() <= list.get(high).getValuePerWeightRatio()) {
      list.set(first, list.get(high));
      list.set(high, pivot);
      return high;
    }
    else {
      return first;
    }
  }

}
