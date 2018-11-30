package nl.hva.ict.ss.util;

import nl.hva.ict.ss.Player;

public class ArrayQuickSort {


    public static void main(String a[]) {
        Player player1 = new Player("AA", "aaa", 446);
        Player player2 = new Player("AA", "aaa", 443);
        Player player3 = new Player("AA", "zz", 446);
        Player player5 = new Player("AA", "zz", 446);
        Player player6 = new Player("AA", "zz", 446);
        Player player7 = new Player("AA", "zz", 446);
        Player player8 = new Player("AA", "zz", 446);

        ArrayQuickSort sorter = new ArrayQuickSort();
        Player[] input = {player1,player2,player3};
        input = sorter.sort(input);
        for (Player i: input) {
            System.out.println(i.getFirstName() + " "+ i.getHighScore() + " ");
        }
    }
    public <E extends Comparable<E>> E[] sort(E[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return inputArr;
        }
        inputArr = quickSort(inputArr, 0, inputArr.length - 1);
        return inputArr;
    }
    private <E extends Comparable<E>> E[] quickSort(E[] inputArray, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        E pivot = inputArray[lowerIndex + (higherIndex - lowerIndex) / 2];
        while (i <= j) {
            while (inputArray[i].compareTo( pivot) == -1) {
                i++;
            }
            while (inputArray[j].compareTo(pivot) == 1) {
                j--;
            }
            if (i <= j) {
                inputArray = exchangeNumbers(inputArray, i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(inputArray, lowerIndex, j);
        if (i < higherIndex)
            quickSort(inputArray, i, higherIndex);
        return inputArray;
    }
    private <E extends Comparable<E>> E[] exchangeNumbers(E[] inputArray, int lowerIndex, int higherIndex) {
        E temp = inputArray[lowerIndex];
        inputArray[lowerIndex] = inputArray[higherIndex];
        inputArray[higherIndex] = temp;
        return inputArray;
    }
}