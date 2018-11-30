package nl.hva.ict.ss;

import nl.hva.ict.ss.util.NameReader;
import org.junit.BeforeClass;
import org.junit.Test;

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
    static final int UPPER_LIMIT = 1000; // 1.048.576
    static final Random randomizer = new SecureRandom();
    static ArrayList<Player> sortedArrayList = new ArrayList<>();
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
            sortedArrayList.add(toAdd);

        }
        Collections.sort(sortedArrayList);
        System.out.printf("%nStart measurements.%n%n");
        System.out.flush();

        // Try to get Java read for steady measurements
//        AdvancedSorts.quickSort(new LinkedList<Player>());

    }

    @Test
    public void measureEfficiencyArray() {
        ArrayList<Player> comparisonList = new ArrayList(AdvancedSorts.quickSort(unsortedLinkedList));
//        unsortedLinkedList =  AdvancedSorts.quickSort(unsortedLinkedList);
//
//        for (Object player: unsortedLinkedList){
//            comparisonList.add(player);
////            System.out.println(player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
//        }
//        for (Player player: comparisonList){
//            System.out.println(player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
//        }
        System.out.println(comparisonList.size());
        for (int i = 0; i <comparisonList.size() ; i++) {
            if (comparisonList.get(i) == sortedArrayList.get(i)){
                System.out.println("jadenk " +  i + " Highscore:"+ comparisonList.get(i).getHighScore() + " " + comparisonList.get(i).getFirstName() + " " + comparisonList.get(i).getLastName());
            }
            else {
System.out.println("1 "+ comparisonList.get(i).getHighScore() + " " + comparisonList.get(i).getFirstName() + " " + comparisonList.get(i).getLastName());
System.out.println("2 "+sortedArrayList.get(i).getHighScore() + " " + sortedArrayList.get(i).getFirstName() + " " + sortedArrayList.get(i).getLastName());
            }
        }
    }

    @Test
    public void measureEfficiencyLinkedList() {
        ArrayList<Player> comparisonList = new ArrayList(AdvancedSorts.quickSort(unsortedLinkedList));

        System.out.println(comparisonList.size());

        Player currentIteration = unsortedLinkedList.getFirst();
        for (Player player : unsortedLinkedList){
            if(currentIteration.compareTo(player)==-1){
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }
            else{
                System.out.println("yep");
            }
        }



//        for (int i = 0; i <comparisonList.size() ; i++) {
//            if (comparisonList.get(i) == sortedArrayList.get(i)){
//                System.out.println("jadenk " +  i + " Highscore:"+ comparisonList.get(i).getHighScore() + " " + comparisonList.get(i).getFirstName() + " " + comparisonList.get(i).getLastName());
//            }
//            else {
//                System.out.println("1 "+ comparisonList.get(i).getHighScore() + " " + comparisonList.get(i).getFirstName() + " " + comparisonList.get(i).getLastName());
//                System.out.println("2 "+sortedArrayList.get(i).getHighScore() + " " + sortedArrayList.get(i).getFirstName() + " " + sortedArrayList.get(i).getLastName());
//            }
//        }
    }
}

//        unsortedLinkedList =  AdvancedSorts.quickSort(unsortedLinkedList);
//
//        for (Object player: unsortedLinkedList){
//            comparisonList.add(player);
////            System.out.println(player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
//        }
//        for (Player player: comparisonList){
//            System.out.println(player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
//        }