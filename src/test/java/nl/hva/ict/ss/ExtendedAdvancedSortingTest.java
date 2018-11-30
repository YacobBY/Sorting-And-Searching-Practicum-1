package nl.hva.ict.ss;

import nl.hva.ict.ss.util.LinkedListQuickSort;
import nl.hva.ict.ss.util.NameReader;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Just measures the time needed that sorting an increasing number of players.
 * The measurements stops if sorting takes more the twenty seconds or when there
 * would be sorted more then 1.048.576 of players.
 *
 * @author Nico Tromp, n.j.tromp@hva.nl
 */
public class ExtendedAdvancedSortingTest {
    static final int MAX_HIGH_SCORE = 100_000;
    static final int TWENTY_SECONDS = 20_000;
    //    static final int UPPER_LIMIT = 1 << 20; // 1.048.576
    static final int UPPER_LIMIT = 10000; // 1.048.576
    static final Random randomizer = new SecureRandom();
    static LinkedList<Player> unsortedLinkedList = new LinkedList<>();

    @BeforeClass
    public static void setup() {
        System.out.printf("Preparing players...");
        System.out.flush();
        String[] firstNames = new NameReader("/firstnames.txt").getNames();
        String[] lastNames = new NameReader("/lastnames.txt").getNames();
        for (int i = 0; i < UPPER_LIMIT; i++) {
            String firstName = firstNames[randomizer.nextInt(firstNames.length)];
            String lastName = lastNames[randomizer.nextInt(lastNames.length)];
            Player toAdd = (new Player(firstName, lastName, randomizer.nextInt(MAX_HIGH_SCORE)));
            unsortedLinkedList.addLast(toAdd);

        }
        LinkedListQuickSort.sortLinkedList(unsortedLinkedList);
        System.out.printf("%nStart measurements.%n%n");
        System.out.flush();

        // Try to get Java read for steady measurements
//        AdvancedSorts.quickSort(new LinkedList<Player>());

    }

    @Test
    public  void checkIfLinkedListIsSorted() {

        assertTrue(linkedListIsSorted(unsortedLinkedList));
    }

    public <E extends Comparable<E>> boolean linkedListIsSorted(LinkedList<E> sortedList) {

        System.out.println(unsortedLinkedList);
        Player currentIteration = unsortedLinkedList.getFirst();
        boolean output = true;
        for (Player player : unsortedLinkedList) {
            if (currentIteration.compareTo(player) == 1) {
                System.out.println("ERROR");
                System.out.println("previous " + currentIteration.getHighScore() + " " + currentIteration.getFirstName() + " " + currentIteration.getLastName());
                System.out.println("current " + player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());

                output = false;
            } else {
                System.out.println("yep");
            }
            currentIteration = player;
        }
        return true;
    }
}
//        assertTrue(true);


//        for (int i = 0; i <comparisonList.size() ; i++) {
//            if (comparisonList.get(i) == sortedArrayList.get(i)){
//                System.out.println("jadenk " +  i + " Highscore:"+ comparisonList.get(i).getHighScore() + " " + comparisonList.get(i).getFirstName() + " " + comparisonList.get(i).getLastName());
//            }
//            else {
//                System.out.println("1 "+ comparisonList.get(i).getHighScore() + " " + comparisonList.get(i).getFirstName() + " " + comparisonList.get(i).getLastName());
//                System.out.println("2 "+sortedArrayList.get(i).getHighScore() + " " + sortedArrayList.get(i).getFirstName() + " " + sortedArrayList.get(i).getLastName());
//            }
//        }


//        unsortedLinkedList =  AdvancedSorts.quickSort(unsortedLinkedList);
//
//        for (Object player: unsortedLinkedList){
//            comparisonList.add(player);
////            System.out.println(player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
//        }
//        for (Player player: comparisonList){
//            System.out.println(player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
//        }