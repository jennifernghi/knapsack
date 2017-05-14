import java.util.ArrayList;

/**
 * modified Quicksort for sorting descending Item based on their value / weight
 * @author jennifernghinguyen
 *
 */
public class QuickSort {
  public static void quickSortPricePerWeight(ID[] list) {
    quickSortPricePerWeight(list, 0, list.length - 1);
  }

  private static void quickSortPricePerWeight(ID[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partitionPricePerWeight(list, first, last);
      quickSortPricePerWeight(list, first, pivotIndex - 1);
      quickSortPricePerWeight(list, pivotIndex + 1, last);
    }
  }

  /** Partition the array list[first..last] */
  private static int partitionPricePerWeight(ID[] list, int first, int last) {
	  ID pivot = list[first]; // Choose the first element as the pivot
	    int low = first + 1; // Index for forward search
	    int high = last; // Index for backward search

	    while (high > low) {
	      // Search forward from left
	      while (low <= high && list[low].getPricePerWeight() > pivot.getPricePerWeight())
	        low++;

	      // Search backward from right
	      while (low <= high && list[high].getPricePerWeight() < pivot.getPricePerWeight())
	        high--;

	      // Swap two elements in the list
	      if (high > low) {
	        ID temp = list[high];
	        list[high] = list[low];
	        list[low] = temp;
	      }
	    }

	    while (high > first && list[high].getPricePerWeight() < pivot.getPricePerWeight())
	      high--;

	    // Swap pivot with list[high]
	    if (pivot.getPricePerWeight() <= list[high].getPricePerWeight()) {
	      list[first] = list[high];
	      list[high] = pivot;
	      return high;
	    }
	    else {
	      return first;
	    }
  }
  
  
  //////////////////////quick sort for price//////////////////
  public static void quickSortPrice(ID[] list) {
	  quickSortPrice(list, 0, list.length - 1);
	  }

	  private static void quickSortPrice(ID[] list, int first, int last) {
	    if (last > first) {
	      int pivotIndex = partitionPrice(list, first, last);
	      quickSortPrice(list, first, pivotIndex - 1);
	      quickSortPrice(list, pivotIndex + 1, last);
	    }
	  }

	  /** Partition the array list[first..last] */
	  private static int partitionPrice(ID[] list, int first, int last) {
		  	ID pivot = list[first]; // Choose the first element as the pivot
		    int low = first + 1; // Index for forward search
		    int high = last; // Index for backward search

		    while (high > low) {
		      // Search forward from left
		      while (low <= high && list[low].getPrice() > pivot.getPrice())
		        low++;

		      // Search backward from right
		      while (low <= high && list[high].getPrice() < pivot.getPrice())
		        high--;

		      // Swap two elements in the list
		      if (high > low) {
		        ID temp = list[high];
		        list[high] = list[low];
		        list[low] = temp;
		      }
		    }

		    while (high > first && list[high].getPrice() < pivot.getPrice())
		      high--;

		    // Swap pivot with list[high]
		    if (pivot.getPrice() <= list[high].getPrice()) {
		      list[first] = list[high];
		      list[high] = pivot;
		      return high;
		    }
		    else {
		      return first;
		    }
	  }
	  
	 

}
