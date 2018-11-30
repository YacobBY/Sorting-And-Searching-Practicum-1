package nl.hva.ict.ss.util;

import java.util.LinkedList;

public class LinkedListQuickSort {

    public static <E extends Comparable<E>> LinkedList<E> sortLinkedList(LinkedList<E> toSortList) {
        if (toSortList == null || toSortList.size() == 0) {
            return toSortList;
        }
        if (toSortList.size() == 1) {
            return (toSortList);
        } else {
            LinkedList returnList = new LinkedList();
            E pivot = toSortList.getFirst();
            LinkedList<E> lowerBound = new LinkedList<>();
            LinkedList<E> higherBound = new LinkedList<>();
            while (toSortList.size() != 1) {
                E listObject = toSortList.pollLast();
                if (pivot.compareTo(listObject) >= 0) { //Last element is smaller or equal to first element and must go left
                    lowerBound.add(listObject);
                } else {
                    higherBound.add(listObject);
                }
            }
            lowerBound = sortLinkedList(lowerBound);
            while (lowerBound.size() != 0) {
                returnList.add(lowerBound.pollFirst());
            }
            returnList.add(pivot);
            higherBound = sortLinkedList(higherBound);
            while (higherBound.size() > 0) {
                returnList.add(higherBound.pollFirst());
            }
            return returnList;
        }
    }


}
