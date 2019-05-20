package com.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArraySwap {
    public static void main(String[] args) {
        testSwapInArray();
    }
    public static void testSwapInArray() {
        int[] array1 = new int[]{0, 1, 0, 1, 1, 0}; //1 swap
        int[] array2 = new int[]{1, 1, 0, 1, 1, 0}; //1 swap
        int[] array3 = new int[]{1, 0, 0, 0, 1, 1}; //1 swap
        int[] array4 = new int[]{1, 0, 1, 1, 0, 1, 0, 0, 1, 1}; //2 swap
        int[] array5 = new int[]{1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1}; //3 swap
        int[] array6 = new int[]{1, 1, 1, 0, 0, 0}; //0 swap
        int[] array7 = new int[]{0, 1}; //0 swap
        List<int[]> arrayList = Arrays.asList(array1, array2, array3, array4, array5, array6, array7);
        arrayList.stream().forEach(a -> arraySwap(a));
    }

    public static void arraySwap(int[] array) {

        int swapCount = 0;

        System.out.println("Before swapping:" + Arrays.toString(array));

        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }

        //to decide collect 0's first then 1's or vice versa
        int leftArraySum = sum(0, array.length / 2, array);
        int rightArraySum = sum(array.length / 2, array.length, array);
        boolean collectZerosFirt = leftArraySum < rightArraySum;

        int startIndex = 0;
        int endIndex = array.length - 1;


        while (startIndex != endIndex) {
            if (array[startIndex] == array[endIndex]) {
                int value = array[startIndex];
                if (collectZerosFirt && value == 0 || !collectZerosFirt && value == 1) {
                    startIndex++;
                } else if (collectZerosFirt && value == 1 || !collectZerosFirt && value == 0) {
                    endIndex--;
                }
                continue;
            } else if (array[startIndex] < array[endIndex] && collectZerosFirt) {
                startIndex++;
                continue;
            } else if (array[startIndex] > array[endIndex] && !collectZerosFirt) {
                endIndex--;
                continue;
            } else {
                swapCount++;
                System.out.println("Swap between index: " + startIndex + " & " + endIndex);
                int temp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;
                if (collectZerosFirt) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }
        System.out.println("Total Swap:" + swapCount);
        System.out.println("After swapping:" + Arrays.toString(array));
        System.out.println("**********************");
        System.out.println();
        System.out.println();

    }

    private static int sum(int fromIndex, int toIndex, int[] array) {
        return IntStream.range(fromIndex, toIndex).map(a -> array[a]).sum();
    }
}
