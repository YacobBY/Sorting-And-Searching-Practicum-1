package nl.hva.ict.ss;

import nl.hva.ict.ss.util.ArrayQuickSort;
import nl.hva.ict.ss.util.LinkedListQuickSort;
import nl.hva.ict.ss.util.NameReader;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.security.SecureRandom;
import java.util.*;

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
    static final int UPPER_LIMIT = 1048400; // 1.048.576
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

        System.out.printf("%nStart measurements.%n%n");
        System.out.flush();
    }

    @Test
    public  void checkLinkedListSorter() {
        LinkedListQuickSort.sortLinkedList(unsortedLinkedList);

        assertTrue(linkedListIsSorted(unsortedLinkedList));
    }
    public boolean linkedListIsSorted(LinkedList<Player> sortedList) {

//        System.out.println(sortedList);
        Player currentIteration = sortedList.getFirst();
        boolean output = true;
        for (Player player : sortedList) {
            if (currentIteration.compareTo(player) >0 ) {
                System.out.println("ERROR");
                System.out.println("previous " + currentIteration.getHighScore() + " " + currentIteration.getFirstName() + " " + currentIteration.getLastName());
                System.out.println("current " + player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
                output = false;
            } else {
                System.out.println("Linkedlist is sorted");
            }
            currentIteration = player;
        }

        return output;
    }


    @Test
    public  void checkIfArrayIsSorted() {{

        Player player1 = new Player("Wouter", "Verdegaal", 420);
        Player player2 = new Player("AKerim", "Airlik", 400);
        Player player3 = new Player("Jan", "deMan", 400);
        Player player4 = new Player("Peter", "van", 400);
        Player player5 = new Player("Pieter", "Baas", 100);
        Player player6 = new Player("Klaas", "Dijkhof", 50);

        Player[] playerArray = {player1, player2, player3, player4, player5, player6};

        //this expectedlist's player order = Klaas,Pieter,AKerim,Jan,Peter,Wouter
        //if the data is changed in one of these players the test should fail. for instance if Peter Van has been changed to Peter Ban
        Player[] sortedArray = AdvancedSorts.quickSort(playerArray);

        Player[] expectedSortofPlayers = {player6, player5, player2, player3, player4, player1};
        assert(Arrays.equals(expectedSortofPlayers, sortedArray));
    }
    }


    LinkedList<Player> getSubList(LinkedList<Player> players, int numberOfPlayers) {
        LinkedList<Player> unsortedPlayers = new LinkedList<>();
        int i = 0;
        for (Player player : players) {
            unsortedPlayers.addLast(player);
            if (++i == numberOfPlayers) break;
        }
        return unsortedPlayers;
    }
}
