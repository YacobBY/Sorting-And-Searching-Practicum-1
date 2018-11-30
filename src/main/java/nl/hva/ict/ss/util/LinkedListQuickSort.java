package nl.hva.ict.ss.util;

import nl.hva.ict.ss.Player;

import java.util.LinkedList;

public class LinkedListQuickSort {
//
//    public static LinkedList returnList = new LinkedList();
//
//    public<E extends Comparable<E>> LinkedList<E> LinkedListQuickSort(LinkedList<E> toSortList){
//        sortLinkedList(toSortList);
//        return returnList;
//    }
    public static void main(String[] args) {
        LinkedList<Player> listie = new LinkedList<>();
        listie.add(new Player("AA", "aaa", 446));
        listie.add(new Player("AA", "aaa", 444));
        listie.add(new Player("ss", "zz", 445));
        listie.add(new Player("AA", "bb", 444));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 443));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 444));
        listie.add(new Player("AA", "zz", 444));


        System.out.println(listie.size());
        listie = sortLinkedList(listie);
        for (Player player:listie){
            System.out.println("current " + player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
        }
//        System.out.println(sortLinkedList(listie));

    }

    public static <E extends Comparable<E>> LinkedList<E> sortLinkedList(LinkedList<E> toSortList) {
        LinkedList returnList = new LinkedList();
        if (toSortList == null ||toSortList.size() == 0) {
            return toSortList;
        }
        if (toSortList.size() == 1) {

            System.out.println("Nothing to sort");
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
                else {
//                    if (pivot.compareTo(listObject) == -1) { //Last element is bigger than first element
                    higherBound.add(listObject);
//                    System.out.println("higherList: " + higherBound);
                }
            }
            System.out.println("fullprint: lb "+lowerBound + " pivot: " + pivot + " hb: "+higherBound);


            System.out.println("Linkedlist " + pivot + "is done sorting");
            lowerBound = sortLinkedList(lowerBound);
            while (lowerBound.size()!=0){
                System.out.println("Deze items kwamen van linksonder:");
                returnList.add(lowerBound.pollFirst());
//                System.out.println(returnList);
            }

            returnList.add(pivot);

            System.out.println("returnlist is nu " + returnList);
            higherBound = sortLinkedList(higherBound);
            while (higherBound.size()>0){
//                System.out.println("Deze items kwamen van rechtsonder:");
                returnList.add(higherBound.pollFirst());
            }


        }
        return returnList;
    }


}
