package nl.hva.ict.ss.util;

import java.util.LinkedList;

public class LinkedListQuickSort {

    public static LinkedList returnList = new LinkedList();

    public<E extends Comparable<E>> void LinkedListQuickSort(LinkedList<E> toSortList){
        sortLinkedList(to)

    }
//    public static void main(String[] args) {
//        LinkedList listie = new LinkedList<Integer>();
//        listie.add(5);
//        listie.add(1);
//        listie.add(2);
//        listie.add(2);
//        listie.add(989);
//        listie.add(989);
//        listie.add(22);
//        System.out.println(listie.size());
//        sortLinkedList(listie);
//        LinkedList listie2;
//        listie2 = sortLinkedList(listie);
//        System.out.println(listie2);
//
////        System.out.println(sortLinkedList(listie));
//
//    }

    public static <E extends Comparable<E>> LinkedList<E> sortLinkedList(LinkedList<E> toSortList) {
        LinkedList returnList = new LinkedList();
        if (toSortList == null ||toSortList.size() == 0) {
            return returnList;
        }
        if (toSortList.size() == 1) {
            returnList.add(toSortList.getFirst());
            System.out.println("Nothing to sort");
            return returnList;
        } else {
            E pivot = toSortList.getFirst();
            LinkedList<E> lowerBound = new LinkedList<>();
            LinkedList<E> higherBound = new LinkedList<>();

            while (toSortList.size() != 1) {
                E listObject = toSortList.pollLast();
                if (pivot.compareTo(listObject) >= 0) { //Last element is smaller or equal to first element and must go left
                    lowerBound.add(listObject);
                    System.out.println("lowerList: " + lowerBound);

                }
                if (pivot.compareTo(listObject) == -1) { //Last element is bigger than first element
                    higherBound.add(listObject);
                    System.out.println("higherList: " + higherBound);
                }
            }
            System.out.println("Linkedlist " + pivot + "is done sorting");
            sortLinkedList(lowerBound);
            if (lowerBound.size()>0){
                System.out.println("groterdan0");
                for (E object:lowerBound){
                    System.out.println(object);
                    returnList.add(object);
                }
            }

            returnList.add(pivot);

            sortLinkedList(higherBound);
            if (higherBound.size()>0){
                for (E object:higherBound){
                    returnList.add(object);
                }
            }

        }
        return returnList;
    }


}
