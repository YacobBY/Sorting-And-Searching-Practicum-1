package nl.hva.ict.ss.util;

import java.util.LinkedList;

public class LinkedListQuickSort {

    public static void main(String[] args) {
        LinkedList listie = new LinkedList<Integer>();
        listie.add(8);
        listie.add(1);
        listie.add(2);
        listie.add(3);
        listie.add(989);
        listie.add(454);
        listie.add(22);
        System.out.println(listie.size());
//        listie = sortLinkedList(listie);
        System.out.println("finalprint +" + listie);

//        System.out.println(sortLinkedList(listie));

    }

    public  <E extends Comparable<E>> LinkedList<E> sortLinkedList(LinkedList<E> toSortList) {
        LinkedList returnList = new LinkedList();
        if (toSortList == null ||toSortList.size() == 0) {
            return returnList;
        }
        if (toSortList.size() == 1) {

//            System.out.println("Nothing to sort");
            return (toSortList);
        } else {
            E pivot = toSortList.getFirst();
            LinkedList<E> lowerBound = new LinkedList<>();
            LinkedList<E> higherBound = new LinkedList<>();

            while (toSortList.size() != 1) {
                E listObject = toSortList.pollLast();
                if (pivot.compareTo(listObject) >= 0) { //Last element is smaller or equal to first element and must go left
                    lowerBound.add(listObject);
//                    System.out.println("lowerList: " + lowerBound);

                }
                else if (pivot.compareTo(listObject) == -1) { //Last element is bigger than first element
                    higherBound.add(listObject);
//                    System.out.println("higherList: " + higherBound);
                }
            }
//            System.out.println("fullprint: lb "+lowerBound + " pivot: " + pivot + " hb: "+higherBound);


//            System.out.println("Linkedlist " + pivot + "is done sorting");
            lowerBound = sortLinkedList(lowerBound);
            while (lowerBound.size()!=0){
//                System.out.println("Deze items kwamen van linksonder:");
                returnList.add(lowerBound.pollFirst());
//                System.out.println(returnList);
            }

            returnList.add(pivot);
//            System.out.println("returnlist is nu " + returnList);
            higherBound = sortLinkedList(higherBound);
            while (higherBound.size()>0){
//                System.out.println("Deze items kwamen van rechtsonder:");
                returnList.add(higherBound.pollFirst());
//                System.out.println(returnList);
            }


        }
        return returnList;
    }


}
