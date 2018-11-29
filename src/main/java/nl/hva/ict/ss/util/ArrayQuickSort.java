package nl.hva.ict.ss.util;

import nl.hva.ict.ss.Player;

public class ArrayQuickSort {


    public static void main(String a[]) {
        Player player1 = new Player("Henk", "Henkie", 12112121);
        Player player2 = new Player("asdfw", "wefqwfe", 1231);
        Player player3 = new Player("dsvcawec", "asdvccaewf", 45243);
        ArrayQuickSort sorter = new ArrayQuickSort();
        Player[] input = {player1,player2,player3};
        input = sorter.sort(input);
        for (Player i: input) {
            System.out.print(i.getFirstName() + " "+ i.getHighScore() + " ");
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
        // calculate pivot number, I am taking pivot as middle index number
        E pivot = inputArray[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (inputArray[i].compareTo( pivot) == -1) {
                i++;
            }
            while (inputArray[j].compareTo(pivot) == 1) {
                j--;
            }
            if (i <= j) {
                inputArray = exchangeNumbers(inputArray, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
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