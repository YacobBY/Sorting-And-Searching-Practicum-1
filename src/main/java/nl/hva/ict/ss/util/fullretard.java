package nl.hva.ict.ss.util;

public class fullretard {


    public static void main(String a[]) {

        fullretard sorter = new fullretard();
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        sorter.sort(input);
        for (int i : input) {
            System.out.print(i + " ");

        }
    }

    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        quickSort(inputArr, 0, inputArr.length - 1);
    }

    private void quickSort(int[] inputArray, int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = inputArray[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (inputArray[i] < pivot) {
                i++;
            }
            while (inputArray[j] > pivot) {
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
    }

    private int[] exchangeNumbers(int[] inputArray, int lowerIndex, int higherIndex) {
        int temp = inputArray[lowerIndex];
        inputArray[lowerIndex] = inputArray[higherIndex];
        inputArray[higherIndex] = temp;
        return inputArray;
    }


}