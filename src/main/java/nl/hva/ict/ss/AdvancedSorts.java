package nl.hva.ict.ss;

import java.util.LinkedList;
import nl.hva.ict.ss.util.fullretard;


public class AdvancedSorts {
    public static fullretard arraySorter = new fullretard();
    /**
     * Implement quicksort using LinkedList only! Usage of anything but LinkedList will result in failing the assignment!
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted) {
        return unsorted;
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will result in failing the assignment!
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted  )
    {

        arraySorter.sort(unsorted);
        return unsorted ;

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
