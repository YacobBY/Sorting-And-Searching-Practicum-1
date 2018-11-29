package nl.hva.ict.ss.util;

import java.util.LinkedList;

public class LinkedListQuickSort {
    public static void main(String[] args) {
        LinkedList listie = new LinkedList<Integer>();
        listie.add(5);
        listie.add(1);
        listie.add(2);
        listie.add(2);
        listie.add(1);
        listie.add(2);
        listie.add(3);
        System.out.println(listie.size());

        System.out.println(sortLinkedList(listie));


    }

    public static <E extends Comparable<E>> LinkedList sortLinkedList(LinkedList<E> toSortList) {
        if (toSortList == null || toSortList.size() <= 1) {
            return toSortList;
        }

//        toSortList = quickSort(inputArr, 0, inputArr.length - 1);

        return toSortList;
    }



}
