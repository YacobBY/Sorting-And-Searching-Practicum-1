package nl.hva.ict.ss;

import nl.hva.ict.ss.util.ArrayQuickSort;
import nl.hva.ict.ss.util.LinkedListQuickSort;

import java.util.LinkedList;


public class AdvancedSorts {

    public static ArrayQuickSort arraySorter = new ArrayQuickSort();

    /**
     * Implement quicksort using LinkedList only! Usage of anything but LinkedList will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static  <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted) {
        LinkedListQuickSort a;
        a = new LinkedListQuickSort();
//        a.LinkedListQuickSort(unsorted);
        quickSort(unsorted);

        return unsorted;
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted) {

        arraySorter.sort(unsorted);
        return unsorted;

    }


//
//    private static int partition(Comparable[] a, int lo, int hi)
//    {
//        int i = lo, j = hi+1;
//        while (true)
//        {
//            while (less(a[++i], a[lo]))
//                if (i == hi) break;
//            while (less(a[lo], a[--j]))
//                if (j == lo) break;
//            if (i >= j) break;
//            exch(a, i, j);
//        }
//        exch(a, lo, j);
//        return j;
//    }

}
